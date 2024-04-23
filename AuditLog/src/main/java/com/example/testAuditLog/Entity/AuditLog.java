package com.example.testAuditLog.Entity;

import java.sql.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AuditLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long logID;
    private Timestamp timestamp;
    private String user;
    private String actionPerformed;
    private long objectID;
    private String objectType;
	public long getLogID() {
		return logID;
	}
	public void setLogID(long logID) {
		this.logID = logID;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getActionPerformed() {
		return actionPerformed;
	}
	public void setActionPerformed(String actionPerformed) {
		this.actionPerformed = actionPerformed;
	}
	public long getObjectID() {
		return objectID;
	}
	public void setObjectID(long objectID) {
		this.objectID = objectID;
	}
	public String getObjectType() {
		return objectType;
	}
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	public AuditLog(long logID, Timestamp timestamp, String user, String actionPerformed, long objectID,
			String objectType) {
		super();
		this.logID = logID;
		this.timestamp = timestamp;
		this.user = user;
		this.actionPerformed = actionPerformed;
		this.objectID = objectID;
		this.objectType = objectType;
	}
	public AuditLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AuditLog [logID=" + logID + ", timestamp=" + timestamp + ", user=" + user + ", actionPerformed="
				+ actionPerformed + ", objectID=" + objectID + ", objectType=" + objectType + "]";
	}
	
    
    
}
	