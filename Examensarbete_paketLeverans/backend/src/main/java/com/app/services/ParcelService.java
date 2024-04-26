package com.app.services;

import com.app.controllers.types.OrderTypes.OrderResponse;
import com.app.controllers.types.OrderTypes.OrderUpdateRequest;
import com.app.controllers.types.ParcelTypes.ParcelCreateRequest;
import com.app.controllers.types.ParcelTypes.ParcelDeleteRequest;
import com.app.controllers.types.ParcelTypes.ParcelResponse;
import com.app.controllers.types.ParcelTypes.ParcelUpdateRequest;
import com.app.data.entities.Order;
import com.app.data.entities.Parcel;
import com.app.data.repositories.ParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParcelService {

    @Autowired
    ParcelRepository parcelRepository;

    public ResponseEntity<ParcelResponse> createNewParcel (ParcelCreateRequest parcelCreateRequest){
        Parcel parcel = new Parcel();

        parcel.setParcelHeight(parcelCreateRequest.getParcelHeight());
        parcel.setParcelWidth(parcelCreateRequest.getParcelWidth());
        parcel.setParcelLength(parcelCreateRequest.getParcelLength());

        return ResponseEntity.ok(new ParcelResponse(parcelRepository.save(parcel)));
    }

    public ResponseEntity<ParcelResponse> updateParcel(ParcelUpdateRequest parcelUpdateRequest) {
        Optional<Parcel> parcel = parcelRepository.findById(parcelUpdateRequest.getId());

        if (parcel.isEmpty())
            return ResponseEntity.notFound().build();

        if (parcel.isPresent()) {
            parcel.get().setParcelHeight(parcelUpdateRequest.getParcelHeight());
            parcel.get().setParcelWidth(parcelUpdateRequest.getParcelWidth());
            parcel.get().setParcelLength(parcelUpdateRequest.getParcelLength());


        }

        return ResponseEntity.ok(new ParcelResponse(parcelRepository.save(parcel.get())));




    }
    public void deleteParcelById (ParcelDeleteRequest parcelDeleteRequest){
            parcelRepository.deleteById(parcelDeleteRequest.getId());
    }

    public Optional<Parcel> getParcelById(long id) {
        return parcelRepository.findById(id);
    }

    public void getAllParcels (){

    }

    public void getParcelByUserId (int id){

    }


}
