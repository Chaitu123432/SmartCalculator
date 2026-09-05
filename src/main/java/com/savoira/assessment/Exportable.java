package com.savoira.assessment;

public interface Auditable {

    String getAuditLog();

    default String getAuditPrefix() {
        return "[AUDIT] ";
    }
}