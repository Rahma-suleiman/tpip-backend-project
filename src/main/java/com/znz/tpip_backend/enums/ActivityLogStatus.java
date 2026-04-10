package com.znz.tpip_backend.enums;

public enum ActivityLogStatus {
    DRAFT,       // Intern is still writing/editing the log
    SUBMITTED,   // Intern has submitted the log
    REVIEWED,    // Mentor has reviewed the log
    APPROVED,    // Mentor accepts the log as valid
    REJECTED     // Mentor requests correction/improvement
}