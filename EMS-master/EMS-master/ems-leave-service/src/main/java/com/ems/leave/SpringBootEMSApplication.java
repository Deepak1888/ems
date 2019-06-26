package com.ems.leave;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author yogesh.patil
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class SpringBootEMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEMSApplication.class, args);
	}
	
}
	@RefreshScope
	@RestController
	class MessageRestController {
	 
	    @Value("${msg:emsleaveservice - Config Server is not working..pelase check}")
	    private String msg;
	 
	    @RequestMapping("/msg")
	    String getMsg() {
	        return this.msg;
	    }
	    
	    @Value("${commonmsg:emsleaveservice common msg- Config Server is not working..pelase check}")
	    private String commonmsg;
	 
	    @RequestMapping("/commonmsg")
	    String getCommonMsg() {
	        return this.commonmsg;
	    }
	    
	    @Value("${eureka.client.serviceUrl.defaultZone:emsleaveservice eurekaServerUrl- Config Server is not working..pelase check}")
	    private String eurekaServerUrl;
	 
	    @RequestMapping("/eurekaServerUrl")
	    String getEurekaServerUrl() {
	        return this.eurekaServerUrl;
	    }
}