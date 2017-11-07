package com.example.userinsight.myapplication;

/**
 * Created by Userinsight on 2017-11-07.
 */

public class RSSI_modeling {

    private double coefficientNap = 0.7141178;
    private double coefficientFlap = 0.3912203;
    private double d = 5.0; // 송신기와 핑거프린트 사이의 거리(?)
    private int number_floor=5;
    private double tx;

    private double result_rssi;

    public RSSI_modeling()
    {

    }

    public RSSI_modeling(double tx)
    {
        this.tx = tx;
    }

    public double CalculateRSSI()
    {
        result_rssi = tx - coefficientNap * Math.log10(d)-10*coefficientNap*Math.log10(10)-coefficientNap*coefficientFlap;

        return result_rssi;

    }
}
