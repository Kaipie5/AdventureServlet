package com.stockcharts.interns.adventuregame.locations;


import com.stockcharts.interns.adventuregame.*;

import java.util.*;

public class CenterLocation implements LocationState {

    private final Game game;
    
    public CenterLocation(Game game) {
        this.game = game;
    }
    
    @Override
    public String getTemplate() {
        return "navigate.tpl";
    }
    
    @Override
    public String getLocationMessage() {
        return "Center";
    }

    @Override
    public Monster getMonster() {
        return null;
    }

    @Override
    public Item getItem() {
        return null;
    }

    @Override
    public void moveNorth() {
        game.setLocation(game.northOne);
    }

    @Override
    public void moveEast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveWest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moveSouth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
