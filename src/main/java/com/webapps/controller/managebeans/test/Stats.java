/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapps.controller.managebeans.test;

/**
 *
 * @author Sameera
 */
import java.io.Serializable;

public class Stats implements Serializable {

    private String season;

    private int win;

    private int loss;

    public Stats() {
    }

    public Stats(String season, int win, int loss) {
        this.season = season;
        this.win = win;
        this.loss = loss;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
