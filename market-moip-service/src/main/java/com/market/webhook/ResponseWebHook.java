package com.market.webhook;


public class ResponseWebHook {

    private String event;

    private ResourceWebHook resource;

    public ResponseWebHook() {
    }

    public ResponseWebHook(String event, ResourceWebHook resource) {
        this.event = event;
        this.resource = resource;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public ResourceWebHook getResource() {
        return resource;
    }

    public void setResource(ResourceWebHook resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "ResponseWebHook{" +
                "event='" + event + '\'' +
                ", resource=" + resource +
                '}';
    }
}
