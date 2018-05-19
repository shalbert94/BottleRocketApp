package com.example.shalom.bottlerocketapp.service.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Stores {

    @SerializedName("stores")
    @Expose
    private List<Store> storeList = null;

    public List<Store> getStoreList() {
        return storeList;
    }

    public void setStores(List<Store> storeList) {
        this.storeList = storeList;
    }

}
