package com.gordon.bowling.app;

import com.gordon.bowling.model.GameTypeParams;
import com.gordon.bowling.services.ConsoleService;
import com.gordon.bowling.services.GameService;
import com.gordon.bowling.services.ScoreboardService;
import mockit.Expectations;
import mockit.Injectable;
import mockit.integration.junit4.JMockit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by gordonwilkinson on 2018-12-08.
 */
@RunWith(JMockit.class)
public class ScoreboardTest {

    GameService gameService;

    @Injectable
    ConsoleService consoleService;

    @Injectable
    ScoreboardService scoreboardService;

    @Before
    public void verifyGameInitialization() {
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
        new Expectations() {{
            int[][] scores = {
                    {10, 0},
                    {10, 0},
                    {10, 0},
                    {10, 0},
                    {10, 0},
                    {10, 0},
                    {10, 0},
                    {10, 0},
                    {10, 0},
                    {10, 10, 10}
            };
            consoleService.getFrameScores();
            result = scores;
        }};

        System.out.println(String.format("Game score: %s", gameService.getGameScore()));
        assertThat(gameService.getGameScore(), is(GameTypeParams.TEN_PIN.getPerfectScore()));
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
