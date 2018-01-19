package com.example.negin.mapapplication.Map;

import com.example.negin.mapapplication.DAL.Address;
import com.example.negin.mapapplication.DAL.Results;
import com.example.negin.mapapplication.utils.Constants;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Negin on 10/01/2018.
 */

public class MapModel {
     MapContract.Presenter presenter;


    public MapModel(MapContract.Presenter presenter) {
        this.presenter = presenter;
    }
    public void GoogleTextToPoint(String address){

        Constants.mapService.ConvertStringToGeoPoint(address).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(this::onResponse,this::onError,this::onComplete) ;
    }

    private void onResponse(Address s) {
//        Results result=(Results)s;
        presenter.GetGeoPointResult(s.getResults()[0].getGeometry().getLocation());
//
//        s.getResults()[0].getGeometry().getLocation();

    }
    private void onComplete() {

    }

    private void onError(Throwable throwable) {

        presenter.onSearchError(throwable.getMessage().toString());
    }



}
