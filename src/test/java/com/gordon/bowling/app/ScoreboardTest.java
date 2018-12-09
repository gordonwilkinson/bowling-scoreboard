package com.gordon.bowling.app;


import com.gordon.bowling.services.ConsoleService;
import com.gordon.bowling.services.GameService;
import com.gordon.bowling.services.ScoreboardService;
import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
/**
 * Created by gordonwilkinson on 2018-12-08.
 */

public class ScoreboardTest {

    GameService gameService;
    ConsoleService consoleService;
    ScoreboardService scoreboardService;


    @Before
    public void verifyGameInitialization() {
        consoleService = new ConsoleService();
        scoreboardService = new ScoreboardService();
        gameService = new GameService(consoleService, scoreboardService);
        assertThat(gameService, is(notNullValue()));
    }

    @Test
    public void verifyZeroScore() {


    }

    @Test
    public void verifyPerfectGame() {

    }

    @Test
    public void verifySpareScore() {

    }

    @Test
    public void verifyStrikeScore() {

    }

    @Test
    public void verifyExtraFrameScoreIgnored() {

    }


}
