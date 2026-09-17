package com.savoira.assessment3;

public interface Auditable {

    String getAuditLog();

    default String getAuditPrefix() {
        return "[AUDIT] ";
    }
}