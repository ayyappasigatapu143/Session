package com.info.beans.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.info.beans.config.EmployeeConfig;

@SpringBootApplication
@Import(EmployeeConfig.class)
public class ServerApplication {
  
 	 public static void main(String[] args) {

                
		SpringApplication.run(ServerApplication.class, args);
	}
}
