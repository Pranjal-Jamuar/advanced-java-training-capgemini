package com.lpu.example;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Engine {

    @Id
    private long id;

    private float cc;

    public Engine() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getCc() {
        return cc;
    }

    public void setCc(float cc) {
        this.cc = cc;
    }
}
