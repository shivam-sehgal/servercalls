package com.skeleton.model;

/**
 * Created by user on 5/10/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CurrentLocation {

    @SerializedName("coordinates")
    @Expose
    private List<Integer> coordinates = null;
    @SerializedName("type")
    @Expose
    private String type;

    public List<Integer> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Integer> coordinates) {
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}