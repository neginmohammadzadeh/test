package com.example.negin.mapapplication.DAL;

/**
 * Created by Negin on 12/01/2018.
 */

public class Results {

    private String place_id;

    private com.example.negin.mapapplication.DAL.address_components[] address_components;

    private String formatted_address;

    private String[] types;

    private com.example.negin.mapapplication.DAL.geometry geometry;

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public com.example.negin.mapapplication.DAL.address_components[] getAddress_components() {
        return address_components;
    }

    public void setAddress_components(com.example.negin.mapapplication.DAL.address_components[] address_components) {
        this.address_components = address_components;
    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public com.example.negin.mapapplication.DAL.geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(com.example.negin.mapapplication.DAL.geometry geometry) {
        this.geometry = geometry;
    }

//    @Override
//    public String toString() {
//        return "ClassPojo [place_id = " + place_id + ", address_components = " + address_components + ", formatted_address = " + formatted_address + ", types = " + types + ", geometry = " + geometry + "]";
//    }
}