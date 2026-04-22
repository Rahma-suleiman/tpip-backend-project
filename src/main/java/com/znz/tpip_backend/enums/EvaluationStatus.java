package com.znz.tpip_backend.enums;

public enum EvaluationStatus {
    PENDING,            // created but not finalized
    PASSED,             // successful
    // NEEDS_IMPROVEMENT,
    // OR
    FAILED,             // failed final evaluation
    REQUIRES_EXTENSION  // must extend internship
}
