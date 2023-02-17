package org.teamcifo.logic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.teamcifo.utils.Helpers;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BoardGame {
    private String gameID;
    private String gameTitle;
    private int minPlayers;
    private int maxPlayers;
    private int minPlayTime;
    private int maxPlayTime;

    // is usefully to have a no params constructor?
    public BoardGame(String gameTitle){
        this.gameID = Helpers.generateUUID();
        this.gameTitle = gameTitle;
        //this.minPlayers = 0;
        //this.maxPlayers = 0;
        //this.minPlayTime = 0;
        //this.maxPlayTime = 0;
    }
    public BoardGame(String gameTitle, int minPlayers, int maxPlayers, int minPlayTime, int maxPlayTime){
        this.gameID = Helpers.generateUUID();
        this.gameTitle = gameTitle;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.minPlayTime = minPlayTime;
        this.maxPlayTime = maxPlayTime;
    }
}
