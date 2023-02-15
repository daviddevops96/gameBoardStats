package org.teamcifo.domain;

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
    private int minPlayingTime;
    private int maxPlayingTime;

    public BoardGame(String gameTitle){
        this.gameID = Helpers.generateUUID();
        this.gameTitle = gameTitle;
    }

}
