package com.globant.EMS.proxies;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.globant.EMS.loadbalancer.RibbonConfiguration;
import com.globant.EMS.model.User;

/**
 * 
 */

/**
 * @author mayuri.shinde
 *
 */
@FeignClient(name="ems-leave-service" )//Service Id of EmployeeLeave service
@RibbonClient(name="ems-leave-service",configuration = RibbonConfiguration.class)
public interface EMSLeaveServiceProxy {
	 @RequestMapping("/getLeaveDataForAllEmployees")
	   public JSONObject getLeaveDataForAllEmployees();
	 @RequestMapping("/leaves/{id}")
	   public List<User> findById(@PathVariable(value="id") Integer id);
	
	
}
