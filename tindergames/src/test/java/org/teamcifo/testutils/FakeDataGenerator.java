package org.teamcifo.testutils;

import com.github.javafaker.Faker;
import org.teamcifo.domain.BoardGame;
import org.teamcifo.domain.GameStats;
import org.teamcifo.domain.GamesCollection;
import org.teamcifo.domain.User;
import org.teamcifo.utils.Helpers;

import java.util.ArrayList;
import java.util.List;

public class FakeDataGenerator {

    private static Faker faker = new Faker();

    public static List<BoardGame> populateBoardGames(int numGames) {
        // TODO: Create a random number of BoardGames and return them
        List<BoardGame> boardGameList = new ArrayList<>();
        for (int i = 0; i < numGames; i++) {
            boardGameList.add(createFakeGame());
        }
        return boardGameList;
    }

    public static List<GamesCollection> populateGamesCollection(int numCollections) {
        // Create a random list of BoardGames
        List<BoardGame> boardGameList = populateBoardGames(faker.number().numberBetween(1, 10));
        List<GamesCollection> gamesCollectionsList = new ArrayList<>();
        for (int i = 0; i < numCollections; i++) {
            // Create an empty gamesCollections List
            GamesCollection newGamesCollection = new GamesCollection();
            // Get a random number of games to populate based on the ones available
            int randomGames = faker.number().numberBetween(1, boardGameList.size());
            for (int j = 0; j < randomGames; j++) {
                // Select a random game
                int randomGame = faker.number().numberBetween(0, boardGameList.size());
                String randomGameID = boardGameList.get(randomGame).getGameID();
                // Insert that game into the collection
                newGamesCollection.addGameToCollection(randomGameID);
                // Set random stats to the game
                newGamesCollection.updateGameStats(randomGameID, createFakeStats());
            }
            // Add the collection to the collections list
            gamesCollectionsList.add(newGamesCollection);
        }
        // Return the populated list
        return gamesCollectionsList;
    }

    public static List<User> populateUsers(int numUsers) {
        // TODO: Create a random number of users and return them
        return new ArrayList<>();
    }

    public static BoardGame createFakeGame() {
        String gameID = Helpers.generateUUID();
        String gameTitle = faker.esports().game();
        int minPlayers = faker.number().numberBetween(1, 4);
        int maxPlayers = faker.number().numberBetween(minPlayers, 10);
        int minPlayingTime = faker.number().numberBetween(10, 30);
        int maxPlayingTime = faker.number().numberBetween(minPlayingTime, 240);

        return new BoardGame(gameID, gameTitle, minPlayers, maxPlayers, minPlayingTime, maxPlayingTime);
    }

    public static GameStats createFakeStats() {
        double buyPrice = faker.number().randomDouble(2, 5, 200);
        int numTimesPlayed = faker.number().numberBetween(1, 100);
        int numWins = faker.number().numberBetween(0, numTimesPlayed);
        boolean owned = faker.bool().bool();

        GameStats fakeStats = new GameStats();
        fakeStats.setBuyPrice(buyPrice);
        fakeStats.setNumTimesPlayed(numTimesPlayed);
        fakeStats.setNumWins(numWins);
        fakeStats.setOwned(owned);

        return fakeStats;
    }
}
