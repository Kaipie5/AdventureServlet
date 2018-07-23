package com.stockcharts.interns.adventuregame.playerstates;

import com.stockcharts.interns.adventuregame.Game;


public class DecideState implements PlayerState {

    private Game game;
    public DecideState(Game game) {
        this.game = game;
    }
    
    @Override
    public String getTemplate() {
        return "decide.tpl";
    }

}
