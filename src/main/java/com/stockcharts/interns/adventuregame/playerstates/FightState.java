package com.stockcharts.interns.adventuregame.playerstates;


import com.stockcharts.interns.adventuregame.Game;
import java.util.*;

public class FightState implements PlayerState {

    private Game game;
    public FightState(Game game) {
        this.game = game;
    }
    
    @Override
    public String getTemplate() {
        return "fight.tpl";
    }

    
}
