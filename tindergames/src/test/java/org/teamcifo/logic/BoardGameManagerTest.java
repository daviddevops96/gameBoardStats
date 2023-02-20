package org.teamcifo.logic;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.teamcifo.domain.BoardGame;
import org.teamcifo.utils.FakeDataGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BoardGameManagerTest {

    @Test
    public  void createBoardGame(){
        // create a single boardgame manually
        BoardGame game;
        game = BoardGameManager.createBoardGame("Catan", 1, 4, 60, 120);

        assertEquals("Catan", game.getGameTitle());
        assertNotEquals("Pandemic", game.getGameTitle());

        //create a fake game
        BoardGame fakeGame;
        fakeGame = FakeDataGenerator.createFakeGame();
        String gameTitle = fakeGame.getGameTitle();
        assertEquals(gameTitle, fakeGame.getGameTitle());
    }
    @Test
    public void setGameTitleTest(){
        Faker fake = new Faker();
        String FakeNewGameTitle = fake.backToTheFuture().character();
        BoardGame game = FakeDataGenerator.createFakeGame();
        String gameTitle = game.getGameTitle();
        game.setGameTitle(FakeNewGameTitle);
        assertNotEquals(gameTitle, game.getGameTitle());

    }
    @Test
    public void setGameMinPlayers(){
        Faker fake = new Faker();
        BoardGame game = FakeDataGenerator.createFakeGame();
        int minPlayerCount = game.getMinPlayers();
        int newMinPlayerCount = fake.number().numberBetween(1, 6);
        game.setMinPlayers(newMinPlayerCount);
        assertNotEquals(minPlayerCount, game.getMinPlayers());

    }
    @Test
    public void setGameMaxPlayers(){
        Faker fake = new Faker();
        BoardGame game = FakeDataGenerator.createFakeGame();
        int maxPlayerCount = game.getMaxPlayers();
        int newMaxPlayerCount =fake.number().numberBetween(6, 20);
        game.setMaxPlayers(newMaxPlayerCount);
        assertNotEquals(maxPlayerCount, game.getMaxPlayers());

    }
    @Test
    public void setGameMinPlayTime(){
        Faker fake = new Faker();
        BoardGame game = FakeDataGenerator.createFakeGame();
        int minPlayTime = game.getMinPlayTime();
        int newMinPlayTime =fake.number().numberBetween(30, 90);
        game.setMinPlayTime(newMinPlayTime);
        assertNotEquals(minPlayTime, game.getMinPlayTime());

    }
    @Test
    public void setGameMaxPlayTime(){
        Faker fake = new Faker();
        BoardGame game = FakeDataGenerator.createFakeGame();
        int maxPlayTime =game.getMaxPlayTime();
        int newMaxPlayTime= fake.number().numberBetween(1, 6);
        game.setMaxPlayTime(newMaxPlayTime);
        assertNotEquals(maxPlayTime, game.getMaxPlayTime());

    }
    // method for populating BoardGameDB for testing needed

    // test for search a boardgame needed
}