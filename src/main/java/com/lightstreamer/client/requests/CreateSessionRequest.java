package com.lightstreamer.client.requests;

import com.lightstreamer.client.session.InternalConnectionDetails;
import com.lightstreamer.client.session.InternalConnectionOptions;


public final class CreateSessionRequest extends SessionRequest {
    public String getRequestName() {
        return "create_session";
    }

    public boolean isSessionRequest() {
        return true;
    }

    public CreateSessionRequest(String targetServer, boolean polling, String cause, InternalConnectionOptions options, InternalConnectionDetails details, long delay, String password, String oldSession) {
        super(polling, delay);
        System.out.println("CreateSessionRequest");

        this.setServer(targetServer);
        this.addParameter("LS_op2", "create");
        this.addParameter("LS_polling", "true");
        if (cause != null) {
            this.addParameter("LS_cause", cause);
        }

        long requestedPollingInterval = 0L;
        long requestedIdleTimeout = 0L;
        if (polling) {
            requestedPollingInterval = options.getPollingInterval() + delay;
            requestedIdleTimeout = options.getIdleTimeout();
        }

        this.addParameter("LS_polling_millis", requestedPollingInterval);
        this.addParameter("LS_idle_millis", requestedIdleTimeout);
        this.addParameter("LS_cid", "tqGko0tg4pkpW3CAN3O4hwLri8LBSG55l");
        if (options.getInternalMaxBandwidth() > 0.0D) {
            this.addParameter("LS_requested_max_bandwidth", options.getInternalMaxBandwidth());
        }

        if (details.getAdapterSet() != null) {
            this.addParameter("LS_adapter_set", details.getAdapterSet());
        }

        if (details.getUser() != null) {
            this.addParameter("LS_user", details.getUser());
        }

        if (password != null) {
            this.addParameter("LS_password", password);
        }

        if (oldSession != null) {
            this.addParameter("LS_old_session", oldSession);
        }

        this.addParameter("LS_report_info", "true");
    }
}
