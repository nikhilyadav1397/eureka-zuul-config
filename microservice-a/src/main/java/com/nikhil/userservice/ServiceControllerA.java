package com.nikhil.userservice;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceControllerA {
	private Environment env;

	public ServiceControllerA(Environment env) {
		super();
		this.env = env;
	}
	
	@GetMapping("/status")
	@LoadBalanced
	public ResponseEntity<String> getStatus() {
		return new ResponseEntity<String>("Hello From"+env.getProperty("local.server.port"),HttpStatus.OK);
	}
}
