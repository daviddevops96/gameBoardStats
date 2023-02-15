package org.teamcifo.logic;

import org.teamcifo.utils.Helpers;
import org.teamcifo.domain.BoardGame;

public class BoardGameManager {
    // we need how to decide how to storage boardgames

    public static void createBoardGame(){
        // will create a singe boardgame
    }

    public static void createMultipleBoardGames(int number){
        // can create multiple boardgames at the same time
        //maybe only for testing?
    }

    public static void updateBoardGame(){
        // can update BoardGame parameters.
        // Will update the game from the DB, not from the user collection
    }

    public static void searchBoardGame(String gameTitle){
        // will search the desired boardGame and shows it to user.
        // can be a game for own collection or from all games DB
    }

    public static void listAllBoardgames(){
        // the user can browse the whole boardGames DB
    }
}
