package com.app.controllers;

import com.app.controllers.types.ParcelTypes.ParcelCreateRequest;
import com.app.controllers.types.ParcelTypes.ParcelDeleteRequest;
import com.app.controllers.types.ParcelTypes.ParcelResponse;
import com.app.controllers.types.ParcelTypes.ParcelUpdateRequest;
import com.app.services.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/parcel")
public class ParcelController {

    @Autowired
    ParcelService parcelService;

    public void getAllPackages (){
        parcelService.getAllParcels();
    }

    public void getParcelById(){
            parcelService.getParcelById(1);
    }

    public void getParcelByUserId (int id){
        parcelService.getParcelByUserId(id);
    }

    public ResponseEntity<ParcelResponse> createParcel (@RequestBody ParcelCreateRequest parcelCreateRequest){
        return parcelService.createNewParcel(parcelCreateRequest);
    }

    public ResponseEntity<ParcelResponse> updateParcel (@RequestBody ParcelUpdateRequest parcelUpdateRequest){
        return parcelService.updateParcel(parcelUpdateRequest);
    }

    public void deleteParcel (@RequestBody ParcelDeleteRequest parcelDeleteRequest){
        parcelService.deleteParcelById(parcelDeleteRequest);
    }



}
