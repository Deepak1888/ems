package com.globant.EMS;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableOAuth2Sso
@EnableEncryptableProperties
@EnableDiscoveryClient
@EnableFeignClients 
public class EmsApplication {//implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmsApplication.class, args);
	}
	
	@Bean
	   public RestTemplate restTemplate(RestTemplateBuilder builder) {
	      return builder.build();
	   }

}

@RefreshScope
@RestController
class MessageRestController {
 
    @Value("${msg:Hello world - Config Server is not working..pelase check}")
    private String msg;
 
    @RequestMapping("/msg")
    String getMsg() {
        return this.msg;
    }
    
    @Value("${commonmsg:Hello world common msg- Config Server is not working..pelase check}")
    private String commonmsg;
 
    @RequestMapping("/commonmsg")
    String getCommonMsg() {
        return this.commonmsg;
    }
    
    @Value("${eureka.client.serviceUrl.defaultZone:Hello world eurekaServerUrl- Config Server is not working..pelase check}")
    private String eurekaServerUrl;
 
    @RequestMapping("/eurekaServerUrl")
    String getEurekaServerUrl() {
        return this.eurekaServerUrl;
    }
}
