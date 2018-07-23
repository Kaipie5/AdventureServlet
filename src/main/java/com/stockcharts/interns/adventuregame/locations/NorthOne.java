package com.stockcharts.interns.adventuregame.locations;


import com.stockcharts.interns.adventuregame.*;


public class NorthOne implements LocationState {

    private Game game;
    
    private Monster monster;
    
    public NorthOne(Game game) {
        this.game = game;
        this.monster = new Monster();
    }
    
    @Override
    public String getTemplate() {
        return "navigate.tpl";
    }
    
    @Override
    public String getLocationMessage() {
        return "North 1";
    }

    
    @Override
    public Monster getMonster() {
        return monster;
    }
    

    @Override
    public Item getItem() {
        return null;
    }

    @Override
    public void moveNorth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        game.setLocation(game.centerLocation);
    }

}
