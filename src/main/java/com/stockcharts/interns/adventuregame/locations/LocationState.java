/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stockcharts.interns.adventuregame.locations;

import com.stockcharts.interns.adventuregame.Item;
import com.stockcharts.interns.adventuregame.Monster;

/**
 *
 * @author connorh
 */
public interface LocationState {
    
    public String getTemplate();
    public String getLocationMessage();
    
    public Monster getMonster();
    public Item getItem();
    
    public void moveNorth();
    public void moveEast();
    public void moveWest();
    public void moveSouth();
    
}
