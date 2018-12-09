package com.gordon.bowling.app;

import com.gordon.bowling.services.ConsoleService;
import com.gordon.bowling.services.GameService;
import com.gordon.bowling.services.ScoreboardService;
import mockit.Expectations;
import mockit.Injectable;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by gordonwilkinson on 2018-12-08.
 */

public class ScoreboardTest {

    @Injectable
    GameService gameService;

    @Injectable
    ConsoleService consoleService;

    @Injectable
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
        new Expectations() {{
            int[][] scores = new int[10][3];
            consoleService.getFrameScores();
            result = scores;
        }};
        assertThat(gameService.getGameScore(), is(0));
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
