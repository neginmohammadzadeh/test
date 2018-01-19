package com.example.negin.mapapplication.Map;

import android.content.Context;

import com.example.negin.mapapplication.DAL.location;

/**
 * Created by Negin on 10/01/2018.
 */

public class MapPresenter implements MapContract.Presenter {

    private MapContract.View view;
    private Context comtext;
    MapModel model;

    @Override
    public void attachview(MapContract.View view) {

        this.view = view;
        this.model=new MapModel(this);
    }

    @Override
    public void attachContext(Context comtext) {

        this.comtext = comtext;
    }

    @Override
    public void sendAddressText(String address) {
        model.GoogleTextToPoint(address);
    }

    @Override
    public void GetGeoPointResult(location location) {
        view.onSearchResult(location);
    }

    @Override
    public void onSearchError(String error) {

        view.onSearchError(error);
    }


}
