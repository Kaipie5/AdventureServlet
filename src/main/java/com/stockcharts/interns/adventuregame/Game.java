package com.stockcharts.interns.adventuregame;


import com.stockcharts.interns.adventuregame.playerstates.PlayerState;
import com.stockcharts.interns.adventuregame.locations.*;
import com.stockcharts.interns.adventuregame.playerstates.*;
import java.util.*;

public class Game {
    
    // Current State
    private LocationState playerLocation;
    private PlayerState currentPlayerState;
    
    // Locations
    public final CenterLocation centerLocation;
    public final NorthOne northOne;
    
    // Player States
    public final NavigateState navigateState;
    public final DecideState decideState;
    public final FightState fightState;
    
    public Game() {
        
        centerLocation = new CenterLocation(this);
        northOne = new NorthOne(this);
        
        playerLocation = centerLocation;
        
        navigateState = new NavigateState(this);
        decideState = new DecideState(this);
        fightState = new FightState(this);
        
        currentPlayerState = navigateState;
    }
    
    
    public void movePlayerNorth() {
        playerLocation.moveNorth();
        checkPlayerState();
    }
    
    private void checkPlayerState() {
        
        if (playerLocation.getMonster() != null) {
            currentPlayerState = decideState;
        }
                
    }
    
    public void doPlayerRetreat() {
        
        if (currentPlayerState == decideState) {
            currentPlayerState = navigateState;
        }  
        
    }
   
    public String getTemplate() {
        
        
        if (currentPlayerState == fightState || currentPlayerState == decideState) {
            return currentPlayerState.getTemplate();
        } else {
            return playerLocation.getTemplate(); // Either returns navigate.tpl or a special navigation menu
            
        }
    }
    
    public String getLocationMessage() {
        
        if (currentPlayerState == fightState || currentPlayerState == decideState) {
            return "";
        } else {
            return playerLocation.getLocationMessage(); // Either returns navigate.tpl or a special navigation menu
            
        }
    }
  
    public void setPlayerState(PlayerState newState) {
        currentPlayerState = newState;
    }
    
    public void setLocation(LocationState newLocation) {
        playerLocation = newLocation;
    }

}
