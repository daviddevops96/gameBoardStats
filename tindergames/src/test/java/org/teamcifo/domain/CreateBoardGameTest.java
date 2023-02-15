package org.teamcifo.domain;

import org.junit.jupiter.api.Test;
import org.teamcifo.domain.*;
import org.teamcifo.utils.*;
import org.teamcifo.utils.*;
import com.github.javafaker.Faker;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
public class CreateBoardGameTest {
    //first approach. More to-do
    @Test
    public  void createBoardGameObjectTest(){
        Faker faker = new Faker();
        String gameTitle = faker.backToTheFuture().character();
        BoardGame game = new BoardGame(gameTitle);
        assertEquals(gameTitle, game.getGameTitle());
    }
    @Test
    public  void createMultipleBoardgames(int number){
        Faker faker = new Faker();
        BoardGame newBoardgame;

        for (int i = 0; i < number; i++){
            newBoardgame = new BoardGame();

            String gameID = Helpers.generateUUID();
            String gameTitle = faker.rockBand().name();
            newBoardgame.setGameID(gameID);
            newBoardgame.setGameTitle(gameTitle);
        }
    }

    @Test
    public void createFakeBoardGames(){
        createMultipleBoardgames(10);
    }
    @Test
    public  void settersBoardGameObjectTest(){
        Faker faker = new Faker();
        String gameTitle = faker.backToTheFuture().character();
        String gameID = Helpers.generateUUID();
    }
}
