package com.ems.leave.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.ems.leave.constant.LeaveConstants;
import com.ems.leave.model.LeaveData;
import com.ems.leave.model.Response;
import com.ems.leave.util.LeaveUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

/**
 * 
 * @author yogesh.patil
 *
 */
@Service
public class LeaveServiceImpl implements LeaveService, LeaveConstants {

	@Override
	public JSONObject getLeaveDataForAllEmployees() {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		JSONParser parser = new JSONParser();

		try {
			// Connecting to mongo db
			DBCollection dbCollection = LeaveUtil.getDatabaseConnection(LEAVE_COLLECTION_NAME);
			DBCursor cursor = dbCollection.find();
			while (cursor.hasNext()) {
				JSONObject json = (JSONObject) parser.parse(cursor.next().toString());
				jsonArray.add(json);
			}
			jsonObject.put(LEAVE_RECORDS, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	@Override
	public JSONObject getLeaveDataByEmployeeId(String empid) {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		JSONParser parser = new JSONParser();
		try {
			// Connecting to mongo db
			DBCollection dbCollection = LeaveUtil.getDatabaseConnection(LEAVE_COLLECTION_NAME);
			BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("empid", empid);
			DBCursor cursor = dbCollection.find(whereQuery);

			while (cursor.hasNext()) {
				JSONObject json = (JSONObject) parser.parse(cursor.next().toString());
				jsonArray.add(json);
			}
			jsonObject.put(LEAVE_RECORD, jsonArray);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	@Override
	public Response applyLeave(LeaveData leaveData) {
		Response responseMessage = null;
		try {
			// Connecting to mongo db
			DBCollection dbCollection = LeaveUtil.getDatabaseConnection(LEAVE_COLLECTION_NAME);
			BasicDBObject document = new BasicDBObject();
			document.put("empid", leaveData.getEmpid());
			document.put("firstName", leaveData.getFirstName());
			document.put("lastName", leaveData.getLastName());
			document.put("leaveType", leaveData.getLeaveType());
			document.put("fromDate", leaveData.getFromDate());
			document.put("toDate", leaveData.getToDate());
			document.put("postingDate", leaveData.getPostingDate());
			document.put("adminRemark", leaveData.getAdminRemark());
			document.put("adminRemarkDate", leaveData.getAdminRemarkDate());
			document.put("status", leaveData.getStatus());

			dbCollection.insert(document);
			responseMessage = new Response();
			responseMessage.setMessage("Data added successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseMessage;
	}

}
