package org.teamcifo.logic;

import org.teamcifo.domain.GamesCollection;

public class GamesCollectionManager {

    // TODO: Define what the GamesCollectionManager shall do:
    // The User ID is always required to access its game collection!
    // First approach: create an object for each user to access its game collection
    // Second approach: create a singleton and pass the user argument each time
    // Third approach: Static class that requires user ID parameter each time

    // Third approach - This shall be further discussed based on the use-cases
    // Search an owned game
    // - Search by game ID
    public static void searchGame(String userID, String gameID) {
        GamesCollection gamesCollection = UserManager.getGamesCollection(userID);
        boolean hasGame = gamesCollection.hasGame(gameID);

        if (hasGame) {
            System.out.println("User " + userID + " has the game " + gameID);
        } else {
            System.out.println("User " + userID + " doesn't have the game " + gameID);
        }
    }
    // Add a new game
    // - Add the game ID
    public static void addGame(String userID, String gameID) {
        // Retrieve the GamesCollection from that userID
        // Something like:
        GamesCollection gamesCollection = UserManager.getGamesCollection(userID);
        gamesCollection.addGame(gameID);
    }
    // Update a game?
    // - Nothing to update right now, only the game ID is stored

    // Remove a game
    // - Remove the game ID from the collection
    public static void deleteGame(String userID, String gameID) {
        GamesCollection gamesCollection = UserManager.getGamesCollection(userID);
        gamesCollection.deleteGame(gameID);
    }
}
