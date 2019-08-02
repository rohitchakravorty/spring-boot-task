package com.stackroute.boot;

import com.stackroute.boot.repository.TrackRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@EnableMongoRepositories(basePackageClasses = TrackRepository.class)
public class  BootApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(BootApplication.class, args);
	}
}
