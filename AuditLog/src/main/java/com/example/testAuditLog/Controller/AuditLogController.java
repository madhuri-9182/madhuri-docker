package com.example.testAuditLog.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.testAuditLog.Entity.AuditLog;
import com.example.testAuditLog.repo.AuditLogRepo;

@RestController
public class AuditLogController {
	
	@Autowired
	AuditLogRepo auditLogRepo;
	
	@PostMapping("/api/auditlog")
	public ResponseEntity<AuditLog> createAuditLog(@RequestBody AuditLog auditlog) {
       return new ResponseEntity<>(auditLogRepo.save(auditlog),HttpStatus.CREATED);
    }
	
	@GetMapping("/api/auditlog")
	public ResponseEntity<List<AuditLog>> getAuditLogs() {
		return new ResponseEntity<>(auditLogRepo.findAll(),HttpStatus.OK);
		}
	
	@GetMapping("/api/auditlog/{logID}")
	public ResponseEntity<AuditLog> getAuditLog(@PathVariable long logID) {
		Optional<AuditLog> auditlog = auditLogRepo.findById(logID);
		if(auditlog.isPresent()) {
			return new ResponseEntity<>(auditlog.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/api/auditlog/{logID}")
	public ResponseEntity<AuditLog> updateAuditLog(@PathVariable long logID,@RequestBody AuditLog auditlogs) {
		Optional<AuditLog> auditlog = auditLogRepo.findById(logID);
		if(auditlog.isPresent()) {
			auditlog.get().setTimestamp(auditlogs.getTimestamp());
			auditlog.get().setUser(auditlogs.getUser());
			auditlog.get().setActionPerformed(auditlogs.getActionPerformed());
			auditlog.get().setObjectID(auditlogs.getObjectID());
			auditlog.get().setObjectType(auditlogs.getObjectType());
			return new ResponseEntity<>(auditLogRepo.save(auditlog.get()),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/api/auditlog/{logID}")
	public ResponseEntity<AuditLog> deleteAuditLog(@PathVariable long logID) {
		Optional<AuditLog> auditlog = auditLogRepo.findById(logID);
		if(auditlog.isPresent()) {
			auditLogRepo.deleteById(logID);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
