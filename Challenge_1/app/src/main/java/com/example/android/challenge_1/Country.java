package com.example.android.challenge_1;

import java.io.Serializable;

/**
 * Created by MW on 3/16/2016.
 */
public class Country implements Serializable {

    private String name;
    private String capital;
    private String flag;
    private String details;

    public Country(){}

    public Country(String capital, String flag, String name, String details) {

        this.capital = capital;
        this.flag = flag;
        this.name = name;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
