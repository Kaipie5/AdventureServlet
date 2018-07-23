package com.stockcharts.interns.adventuregame.playerstates;


import com.stockcharts.interns.adventuregame.Game;
import java.util.*;

public class NavigateState implements PlayerState {

    private Game game;
    public NavigateState(Game game) {
        this.game = game;
    }
    
    @Override
    public String getTemplate() {
        return "navigation.tpl";
    }

}
