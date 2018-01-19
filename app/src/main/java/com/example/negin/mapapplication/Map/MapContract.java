package com.example.negin.mapapplication.Map;

import android.content.Context;

import com.example.negin.mapapplication.DAL.location;

/**
 * Created by Negin on 10/01/2018.
 */

public class MapContract {
     interface View{
         public void onSearchResult(location location);
         public void onSearchError(String error);

     }
     interface Presenter{
         public void attachview(View view);
         public void attachContext(Context comtext);
         public void sendAddressText(String address);
         public void GetGeoPointResult(location result);
         public void onSearchError(String error);
     }
}
