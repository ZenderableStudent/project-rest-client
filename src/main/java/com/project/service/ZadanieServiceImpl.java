package com.project.service;

import java.net.URI;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.model.Student;
import com.project.model.Zadanie;



public class ZadanieServiceImpl implements ZadanieService {
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	 @Value("${rest.server.url}") // adres serwera jest wstrzykiwany przez Springa, a jego warto��
	 private String serverUrl; // przechowywana w pliku src/main/resources/application.properties

	 private final static String RESOURCE_PATH = "/api/studenci";
	 // obiekt wstrzykiwany poprzez konstruktor, dzi�ki adnotacjom
	 private RestTemplate restTemplate; // @Configuration i @Bean zawartym w klasie SecurityConfig
	 // Spring utworzy wcze�niej obiekt, a adnotacja @Autowired
	 @Autowired // tej klasy wska�e element docelowy wstrzykiwania
	 public ZadanieServiceImpl(RestTemplate restTemplate) {
	 this.restTemplate = restTemplate;
	 }
	@Override
	public Optional<Zadanie> getZadanie(Integer Id) {
		URI url = ServiceUtil.getUriComponent(serverUrl, getResourcePath(Id))
				 .build()
				 .toUri();
				 logger.info("REQUEST -> GET {}", url);
				 return Optional.ofNullable(restTemplate.getForObject(url, Zadanie.class));
		
	}

	@Override
	public Zadanie setZadanie(Zadanie zadanie) {
		if (zadanie.getZadanieId() != null) { 
			String url = getUriStringComponent(zadanie.getZadanieId());
			 logger.info("REQUEST -> PUT {}", url);
			 restTemplate.put(url, zadanie);
			 return zadanie;
			 } else {
			 HttpEntity<Zadanie> request = new HttpEntity<>(zadanie);
			 String url = getUriStringComponent();
			 logger.info("REQUEST -> POST {}", url);
			 URI location = restTemplate.postForLocation(url, request);
			 logger.info("REQUEST (location) -> GET {}", location);
			 return restTemplate.getForObject(location, Zadanie.class);
	
			 }
			 }

	@Override
	public void deleteZadanie(Integer Id) {
		
		URI url = ServiceUtil.getUriComponent(serverUrl, getResourcePath(Id))
				 .build()
				 .toUri();
				 logger.info("REQUEST -> DELETE {}", url);
				 restTemplate.delete(url);
		
	}

	@Override
	public Page<Zadanie> getZadania(Pageable pageable) {
		URI url = ServiceUtil.getURI(serverUrl, getResourcePath(), pageable);
		 logger.info("REQUEST -> GET {}", url);
		 return getPage(url, restTemplate);
	}

	@Override
	public Page<Zadanie> searchByNazwa(Integer id, Pageable pageable) {
		URI url = ServiceUtil.getUriComponent(serverUrl, getResourcePath(), pageable)
				 .queryParam("Id", id) // moze nie dzialac !!!
				 .build().toUri();
				 logger.info("REQUEST -> GET {}", url);
				 return getPage(url, restTemplate);
				 }
	

	private Page<Zadanie> getPage(URI uri, RestTemplate restTemplate) {
		 return ServiceUtil.getPage(uri, restTemplate,
		 new ParameterizedTypeReference<RestResponsePage<Zadanie>>() {});
		 }
		 private String getResourcePath() {
		 return RESOURCE_PATH;
		 }

		 private String getResourcePath(Integer id) {
		 return RESOURCE_PATH + "/" + id;
		 }

		 private String getUriStringComponent() {
		 return serverUrl + getResourcePath();
		 }

		 private String getUriStringComponent(Integer id) {
		 return serverUrl + getResourcePath(id);
		 }
}