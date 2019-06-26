package com.ems.leave.util;

import com.ems.leave.constant.LeaveConstants;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

/**
 * 
 * @author yogesh.patil
 *
 */
public class LeaveUtil implements LeaveConstants {

	public static DBCollection getDatabaseConnection(String collectionName) {
		DB db = (new MongoClient(LOCALHOST, MONGO_PORT_NO).getDB(DB_NAME));
		DBCollection dbCollection = db.getCollection(collectionName);
		return dbCollection;
	}
}
