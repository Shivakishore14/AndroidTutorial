package com.example.shiva.gpstut1;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

/**
 * Created by shiva on 8/4/17.
 */

public class GPStracker implements LocationListener{
    Context context;
    public GPStracker(Context c){
        context = c;
    }


    public Location getLocation(){


    }
    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }
}
