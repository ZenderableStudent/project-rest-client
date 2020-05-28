package com.project; 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.project.controller.ProjectController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage; 
 
@SpringBootApplication  
public class ProjectClientApplication extends Application {
	private Parent root;
	private FXMLLoader fxmlLoader;
	private ConfigurableApplicationContext springContext; 
 
   public static void main(String[] args) {  
	   launch(ProjectClientApplication.class, args);
	   } 
 
   @Override  
   public void init() throws Exception
   {      
	   springContext = SpringApplication.run(ProjectClientApplication.class);
   fxmlLoader = new FXMLLoader();
   fxmlLoader.setControllerFactory(springContext::getBean);
   } 
 
   @Override
   public void start(Stage primaryStage) throws Exception {
	   fxmlLoader.setLocation(getClass().getResource("/fxml/ProjectFrame.fxml"));
	   root = fxmlLoader.load();
	   primaryStage.setTitle("Projekty");
	   Scene scene = new Scene(root); 
	   scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
	   ProjectController controller = fxmlLoader.getController();
			          primaryStage.
			          setOnCloseRequest (event -> { 
				   primaryStage.hide();         
				   controller.shutdown(); 
				   });  
			   primaryStage.setScene(scene); 
			   primaryStage.sizeToScene();  
			   primaryStage.show();   
			   } 
 
   @Override    
   public void stop() 
   {      
	   springContext.stop();  
	   }
   } 