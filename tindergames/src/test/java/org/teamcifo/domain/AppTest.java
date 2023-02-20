package org.teamcifo;

import org.junit.jupiter.api.Test;
import org.teamcifo.domain.BoardGame;
import org.teamcifo.utils.*;
import com.github.javafaker.Faker;
import static org.junit.jupiter.api.Assertions.*;


public class AppTest {

    public void createBoardGameObjectTest(){
        Faker faker = new Faker();
        String gameTitle = faker.backToTheFuture().character();
        BoardGame game = new BoardGame(gameTitle);
        assertEquals(gameTitle, game.getGameTitle());
    }

    //
    public void settersBoardGameObjectTest(){
        Faker faker = new Faker();
        String gameTitle = faker.backToTheFuture().character();
        String gameID = Helpers.generateUUID();
    }
}
