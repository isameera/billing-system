/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.interfaces;

import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Sameera
 */
public interface DatatableComInterface {

    public void onRowUnselect(UnselectEvent event);

    public void onRowSelect(SelectEvent event);


}
