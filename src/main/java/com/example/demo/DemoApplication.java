package com.example.demo;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.example.demo.model.Demo;
import com.example.demo.repository.DemoRepository;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		DemoRepository demoRepository=context.getBean(DemoRepository.class);
		List<Demo> itr = demoRepository.findAll();
	    itr.forEach(user->{System.out.println(user);});
	}
	
}