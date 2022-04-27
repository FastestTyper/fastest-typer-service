package com.fastesttyper.fastesttyperservice.infrastructure.api.rest.model;

import com.fastesttyper.fastesttyperservice.domain.model.InvitationStatus;

public class InvitationRequest {
    private InvitationStatus status;

    public InvitationStatus getStatus() {
        return status;
    }

    public void setStatus(InvitationStatus status) {
        this.status = status;
    }
}
