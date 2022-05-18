package com.revature.models;

import org.springframework.stereotype.Component;

@Component
public class Avenger {

    private int aveId;
    private String aveName;
    private String power;
    private String firstName;
    private String lastName;
    private int powerLevel;
    
    
    //boilerplate code------------------------------------------------
    
    public Avenger() {
        super();
        // TODO Auto-generated constructor stub
    }


    public Avenger(int aveId, String aveName, String power, String firstName, String lastName, int powerLevel) {
        super();
        this.aveId = aveId;
        this.aveName = aveName;
        this.power = power;
        this.firstName = firstName;
        this.lastName = lastName;
        this.powerLevel = powerLevel;
    }


    @Override
    public String toString() {
        return "Avenger [aveId=" + aveId + ", aveName=" + aveName + ", power=" + power + ", firstName=" + firstName
                + ", lastName=" + lastName + ", powerLevel=" + powerLevel + "]";
    }


    public int getAveId() {
        return aveId;
    }


    public void setAveId(int aveId) {
        this.aveId = aveId;
    }


    public String getAveName() {
        return aveName;
    }


    public void setAveName(String aveName) {
        this.aveName = aveName;
    }


    public String getPower() {
        return power;
    }


    public void setPower(String power) {
        this.power = power;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public int getPowerLevel() {
        return powerLevel;
    }


    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

}
