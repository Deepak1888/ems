package com.ems.leave.service;

import org.json.simple.JSONObject;

import com.ems.leave.model.LeaveData;
import com.ems.leave.model.Response;

/**
 * 
 * @author yogesh.patil
 *
 */
public interface LeaveService {

	JSONObject getLeaveDataForAllEmployees();

	JSONObject getLeaveDataByEmployeeId(String empid);

	Response applyLeave(LeaveData leaveData);
}
