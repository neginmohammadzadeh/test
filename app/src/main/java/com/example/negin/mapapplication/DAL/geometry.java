package com.example.negin.mapapplication.DAL;

/**
 * Created by Negin on 12/01/2018.
 */

    public class geometry {
    private Bounds bounds;

    private Viewport viewport;

    private String location_type;

    private com.example.negin.mapapplication.DAL.location location;

    public Bounds getBounds() {
        return bounds;
    }

    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }

    public String getLocation_type() {
        return location_type;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    public com.example.negin.mapapplication.DAL.location getLocation() {
        return location;
    }

    public void setLocation(com.example.negin.mapapplication.DAL.location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "ClassPojo [bounds = " + bounds + ", viewport = " + viewport + ", location_type = " + location_type + ", location = " + location + "]";
    }
}