package org.teamcifo.storage;
import org.teamcifo.logic.BoardGame;

import java.util.HashMap;
import java.util.Map;


public class BoardGameDataBase {
    private Map<String, BoardGame> boardGamesDB;

    public BoardGameDataBase(){
        this.boardGamesDB =  new HashMap<>();
    }

    // will receive boardgames and storage them.
}
