package com.savoira.week5;

public interface Auditable {

    default String auditPrefix() {
        return "[AUDIT] ";
    }

    String auditSummary();
}
