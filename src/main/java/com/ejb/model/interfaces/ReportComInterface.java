/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.interfaces;

import java.util.List;

/**
 *
 * @author Sameera
 */
public interface ReportComInterface {

    public List<String> customerAutoCompleteCop(String query);

    public List<String> customerAutoComplete(String query);

    public void searchActionCopByDefaultDate();

    public void searchActionCop();

    public void searchActionIndByDefaultDate();

    public void searchActionInd();


}
