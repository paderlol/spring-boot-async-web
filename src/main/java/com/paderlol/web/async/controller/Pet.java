package com.paderlol.web.async.controller;

import java.beans.ConstructorProperties;
import java.io.Serializable;

public class Pet implements Serializable {

    private Integer ownerId;
    private String petId;



    @ConstructorProperties({"ownerId", "petId"})
    public Pet(Integer ownerId, String petId) {
        this.ownerId = ownerId;
        this.petId = petId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "ownerId=" + ownerId +
                ", petId='" + petId + '\'' +
                '}';
    }
}
