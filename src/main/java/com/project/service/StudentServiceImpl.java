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
public class StudentServiceImpl  implements StudentService {

	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	 @Value("${rest.server.url}") // adres serwera jest wstrzykiwany przez Springa, a jego wartoœæ
	 private String serverUrl; // przechowywana w pliku src/main/resources/application.properties

	 private final static String RESOURCE_PATH = "/api/studenci";
	 // obiekt wstrzykiwany poprzez konstruktor, dziêki adnotacjom
	 private RestTemplate restTemplate; // @Configuration i @Bean zawartym w klasie SecurityConfig
	 // Spring utworzy wczeœniej obiekt, a adnotacja @Autowired
	 @Autowired // tej klasy wska¿e element docelowy wstrzykiwania
	 public StudentServiceImpl(RestTemplate restTemplate) {
	 this.restTemplate = restTemplate;
	 }
	
	@Override
	public Optional<Student> getStudent(Integer Id) {
		URI url = ServiceUtil.getUriComponent(serverUrl, getResourcePath(Id))
				 .build()
				 .toUri();
				 logger.info("REQUEST -> GET {}", url);
				 return Optional.ofNullable(restTemplate.getForObject(url, Student.class));
		
	}

	@Override
	public Student setStudent(Student student) {
		if (student.getNr_indeksu() != null) { // modyfikacja istniej¹cego projektu
			String url = getUriStringComponent(student.getStudent_id());
			 logger.info("REQUEST -> PUT {}", url);
			 restTemplate.put(url, student);
			 return student;
			 } else {
			 HttpEntity<Student> request = new HttpEntity<>(student);
			 String url = getUriStringComponent();
			 logger.info("REQUEST -> POST {}", url);
			 URI location = restTemplate.postForLocation(url, request);
			 logger.info("REQUEST (location) -> GET {}", location);
			 return restTemplate.getForObject(location, Student.class);
	
			 }
			 }
	

	@Override
	public void deleteStudent(Integer Id) {
		URI url = ServiceUtil.getUriComponent(serverUrl, getResourcePath(Id))
		 .build()
		 .toUri();
		 logger.info("REQUEST -> DELETE {}", url);
		 restTemplate.delete(url);
		
	}

	@Override
	public Page<Student> getStudenci(Pageable pageable) {
		URI url = ServiceUtil.getURI(serverUrl, getResourcePath(), pageable);
		 logger.info("REQUEST -> GET {}", url);
		 return getPage(url, restTemplate);
	}

	@Override
	public Page<Student> searchByNazwisko(String nazwa, Pageable pageable) {
		 URI url = ServiceUtil.getUriComponent(serverUrl, getResourcePath(), pageable)
				 .queryParam("nazwisko", nazwa)
				 .build().toUri();
				 logger.info("REQUEST -> GET {}", url);
				 return getPage(url, restTemplate);
				 }
	
	
	private Page<Student> getPage(URI uri, RestTemplate restTemplate) {
		 return ServiceUtil.getPage(uri, restTemplate,
		 new ParameterizedTypeReference<RestResponsePage<Student>>() {});
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
	
	
	
	
	
	
	
	/*
	  private StudentRepository studentRepository; 
	
	 @Autowired  
	 public StudentServiceImpl(StudentRepository studentRepository)
	   {     
		   this.studentRepository = studentRepository;  
		   } 
	 
	   @Override    
	   public Optional<Student> getStudent(Integer projektId)
	   {    
		   return studentRepository.findById(projektId);     
	   }
	 

	  public Page<Student> getStudenci(Pageable pageable)
	  {  
		  Page<Student> pr = studentRepository.findAll(pageable);
		  return pr;
	  }
	     
	   public Page<Student> searchByNazwisko(String nazwa, Pageable pageable)
	   {  
		   Page<Student> pr = studentRepository.findByNazwiskoStartsWithIgnoreCase(nazwa, pageable);
		   return pr;
	   }

	@Override
	public Student setStudent(Student student) {
		   Student st = student;
	         studentRepository.save(st);
	         
	         return st;
	         ///?????
		
	}

	@Override
	 @Transactional
	public void deleteStudent(Integer Id) {
		 studentRepository.deleteById(Id);
		
	}

	

	*/

