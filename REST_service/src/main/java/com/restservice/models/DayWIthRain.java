package com.restservice.models;

public class DayWIthRain {
    private int sumOfDaysWithRain;

    public DayWIthRain(){}

    public DayWIthRain(int sumOfDaysWithRain) {
        this.sumOfDaysWithRain = sumOfDaysWithRain;
    }

    public int getSumOfDaysWithRain() {
        return sumOfDaysWithRain;
    }

    public void setSumOfDaysWithRain(int sumOfDaysWithRain) {
        this.sumOfDaysWithRain = sumOfDaysWithRain;
    }
}