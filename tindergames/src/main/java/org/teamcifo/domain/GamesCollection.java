package org.teamcifo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.teamcifo.utils.Helpers;

import java.util.HashMap;
import java.util.Map;

@Data
@Getter
@Setter
public class GamesCollection {
    private String collectionId;
    private Map<String, BoardGame> gamesCollection;

    public GamesCollection() {
        // The collection ID is generated on creation time
        this.collectionId = Helpers.generateUUID();
        this.gamesCollection = new HashMap<>();
    }

    // Public methods
    public void addGame(BoardGame boardGame) {
        // Use the boardGame ID as the hashmap key
        this.gamesCollection.putIfAbsent(boardGame.getGameID(), boardGame);
    }

    public void deleteGame(BoardGame boardGame) {
        // Only try to remove the BoardGame if its gameId exists
        if (this.gamesCollection.containsKey(boardGame.getGameID())) {
            this.gamesCollection.remove(boardGame.getGameID());
        } else {
            System.out.println("Game " + boardGame.getGameTitle() + " is not included in the collection, can't remove it!");
        }
    }

    public void updateGame(BoardGame boardGame) {
        // Don't check if the game already exists in the collection, just put it in
        this.gamesCollection.put(boardGame.getGameID(), boardGame);
    }

    public BoardGame getGame(String boardGameID) {
        return this.gamesCollection.getOrDefault(boardGameID, null);
    }

    public boolean hasGame(BoardGame boardGame) {
        // Check that the collection has an entry with the same game ID and BoardGame as the input one
        return gamesCollection.containsKey(boardGame.getGameID()) && gamesCollection.get(boardGame.getGameID()).equals(boardGame);
    }

    public void copyFrom(Map<String, BoardGame> gamesCollection) {
        this.gamesCollection.putAll(gamesCollection);
    }

    public int size() {
        return this.gamesCollection.size();
    }

    // Methods override
    @Override
    public int hashCode() {
        // As collectionID should already be unique for each collection, we can use it to compute the hashcode
        return this.collectionId.hashCode();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GamesCollection that = (GamesCollection) o;
        // TODO: BoardGame requires an "equals" overridden method
        return getGamesCollection().equals(that.getGamesCollection());
    }


}
