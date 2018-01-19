package com.example.negin.mapapplication.utils;

import com.example.negin.mapapplication.DAL.Address;
import com.example.negin.mapapplication.DAL.Results;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Negin on 10/01/2018.
 */

public interface MapService {
    @GET("/maps/api/geocode/json")
    Observable<Address> ConvertStringToGeoPoint(@Query("address") String address );
}
