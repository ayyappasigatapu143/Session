package com.info.beans.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.info.beans.config.EmployeeConfig;

@SpringBootApplication
@Import(EmployeeConfig.class)
public class ServerApplication {
  
 	 public static void main(String[] args) {

         String x=System.getProperty("env.name");
        System.out.println("sacjasnvjnsajv++++++++++++++++++++++++++++++++++++++++++++"+x+args[0]);

                
		SpringApplication.run(ServerApplication.class, args);
	}
}
