package org.teamcifo.domain;

import org.junit.jupiter.api.Test;
import org.teamcifo.utils.FakeDataGenerator;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BoardGameTest {
    //first approach. More to-do
    @Test
    public  void createBoardGameObjectTest(){
        Faker faker = new Faker();
        String gameTitle = faker.backToTheFuture().character();
        BoardGame game = new BoardGame(gameTitle);
        assertEquals(gameTitle, game.getGameTitle());
    }

    public  void createMultipleBoardgames(int number){

        List<BoardGame> boardGamesList = new ArrayList<>();
        BoardGame gameForTesting = new BoardGame();

        for (int i = 0; i < number; i++){
            gameForTesting = FakeDataGenerator.createFakeGame();
            boardGamesList.add(gameForTesting);
        }
        //System.out.println(boardGamesList);
    }

    public void createFakeBoardGames(){
        createMultipleBoardgames(10);
    }

}
