package com.example.testAuditLog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testAuditLog.Entity.AuditLog;

public interface AuditLogRepo extends JpaRepository<AuditLog, Long>{

}

