package com.example.quakereport;

public class Earthquake {
    private String magnitude;
    private String places;
    private String time;
    public Earthquake(String magnitude,String places,String time) {
        this.magnitude=magnitude;
        this.places=places;
        this.time=time;
    }
    public String getMagnitude()
    {
        return magnitude;
    }
    public String getPlaces()
    {
        return places;
    }
    public  String getTime()
    {
        return time;
    }
}
