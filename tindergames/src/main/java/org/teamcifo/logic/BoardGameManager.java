package org.teamcifo.logic;

import org.teamcifo.domain.BoardGame;

public class BoardGameManager {
    // we need how to decide how to storage boardgames

    public static BoardGame createBoardGame(String gameTitle, int minPlayers, int maxPlayers, int minPlayTime, int maxPlayTime){
        // create a single boardgame
        BoardGame game = new BoardGame(gameTitle, minPlayers, maxPlayers, minPlayTime, maxPlayTime);
        return game;
    }

    // TODO: add games to the DB
    public static void addBoardGameToDB(String gameTitle){
        //add boardgame to BoardGameDataBase
        BoardGame game = new BoardGame(gameTitle);
    }

    // TODO:
    public static void createBoardGameAndAddToStorage(){

    }

    public static void updateGameTitle(BoardGame game, String gameTitle){
        // can update BoardGame parameters.
        // Will update the game from the DB
        game.setGameTitle(gameTitle);
    }

    public static void updateMinPlayers(BoardGame game, int minPlayers){
        // can update BoardGame parameters.
        // Will update the game from the DB
        game.setMinPlayers(minPlayers);
    }

    public static void updateMaxPlayers(BoardGame game, int maxPlayers){
        // can update BoardGame parameters.
        // Will update the game from the DB
        game.setMinPlayers(maxPlayers);
    }

    public static void updateMinPlayTime(BoardGame game,int minPlayTime){
        // can update BoardGame parameters.
        // Will update the game from the DB
        game.setMinPlayTime(minPlayTime);
    }

    public static void updateMaxPlayTime(BoardGame game, int maxPlayTime){
        // can update BoardGame parameters.
        // Will update the game from the DB
        game.setMinPlayTime(maxPlayTime);
    }

    public static void searchBoardGame(String gameTitle){
        // will search the desired boardgame and shows it to user.
        // boardgame will be found on the Board Games DB
    }

    public static void listAllBoardgames(){
        // the user can browse the whole boardGames DB.
        // Some sorting can be defined if wanted
    }
}
