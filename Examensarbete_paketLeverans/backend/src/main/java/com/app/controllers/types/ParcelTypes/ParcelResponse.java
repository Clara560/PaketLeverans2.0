package com.app.controllers.types.ParcelTypes;

import com.app.data.entities.Order;
import com.app.data.entities.Parcel;

import java.util.ArrayList;
import java.util.List;

public class ParcelResponse {



    private List<Parcel> parcels = new ArrayList<Parcel>();


    public ParcelResponse(List<Parcel> parcels) {
        this.parcels = parcels;
    }

    public ParcelResponse (Parcel parcel){
        this.parcels.add(parcel);
    }

    public ParcelResponse () {
    }


    public List<Parcel> getParcels() {
        return parcels;
    }

    public void setParcels(List<Parcel> parcels) {
        this.parcels = parcels;
    }
}
