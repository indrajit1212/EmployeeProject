package com.example.demo.audit;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class AuditImpl{
	@PrePersist
	void preCreate(final Auditing auditable) {

		Audit audit = auditable.getAudit();

		if (audit == null) {
			audit = new Audit();
			auditable.setAudit(audit);
		}

		final LocalDateTime now = LocalDateTime.now();

		audit.setCreatedTimestamp(now);
		//audit.setLastUpdatedTimestamp(now);

		audit.setCreatedBy("Indrajit");

		//audit.setLastUpdatedBy("Sachin");
	}

	@PreUpdate
	void preUpdate(final Auditing auditable) {
		final LocalDateTime now = LocalDateTime.now();

		final Audit audit = auditable.getAudit();

		audit.setLastUpdatedTimestamp(now);

		audit.setLastUpdatedBy("Mahesh");

}
}
