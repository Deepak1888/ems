/**
 * 
 */
package com.globant.EMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globant.EMS.model.User;
import com.globant.EMS.proxies.EMSLeaveServiceProxy;


import org.json.simple.JSONObject;

/**
 * @author mayuri.shinde
 *
 */

@RefreshScope
@RestController
public class FeignLeaveController {
	 @Autowired
	 EMSLeaveServiceProxy emsLeaveProxyService;
	 
	 @RequestMapping("/leaves/feign")
	   public JSONObject findme(){
		 for(int i=0;i<100;i++)	
	       emsLeaveProxyService.getLeaveDataForAllEmployees();
		 return emsLeaveProxyService.getLeaveDataForAllEmployees();
	   }
	 
	 @RequestMapping("/leave/feign/{id}")
	   public List<User> findme(@PathVariable Integer id){
	      return emsLeaveProxyService.findById(id);
	   }
}
