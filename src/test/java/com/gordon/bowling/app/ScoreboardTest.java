package com.gordon.bowling.app;

import com.gordon.bowling.model.GameTypeParams;
import com.gordon.bowling.model.Scoreboard;
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

    ScoreboardService scoreboardService;

    @Before
    public void verifyGameInitialization() {
        scoreboardService = new ScoreboardService(new Scoreboard());
        gameService = new GameService(consoleService, scoreboardService);
        assertThat(gameService, is(notNullValue()));
    }

    @Test
    public void verifyZeroScore() {
        new Expectations() {{
            int[][] scores = {
                    {0, 0},
                    {0, 0},
                    {0, 0},
                    {0, 0},
                    {0, 0},
                    {0, 0},
                    {0, 0},
                    {0, 0},
                    {0, 0},
                    {0, 0, 0}
            };
            consoleService.getFrameScores((int[][]) any);
            result = scores;
        }};
        gameService.playGame();
        assertThat(gameService.getGameScoreResult(), is(0));
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
            consoleService.getFrameScores((int[][]) any);
            result = scores;
        }};
        gameService.playGame();

        System.out.println(String.format("Game score: %s", gameService.getGameScoreResult()));
        assertThat(gameService.getGameScoreResult(), is(GameTypeParams.TEN_PIN.getPerfectScore()));
    }

    @Test
    public void verifySpareScore() {
        new Expectations() {{
            int[][] scores = {
                    {4, 6},
                    {10, 0},
                    {0, 0},
                    {0, 0},
                    {0, 0},
                    {0, 0},
                    {0, 0},
                    {0, 0},
                    {0, 0},
                    {0, 0, 0}
            };
            consoleService.getFrameScores((int[][]) any);
            result = scores;
        }};
        gameService.playGame();

        System.out.println(String.format("Game score: %s", gameService.getGameScoreResult()));
        assertThat(gameService.getGameScoreResult(), is(30));
    }

    @Test
    public void verifyStrikeScore() {

    }

    @Test
    public void verifyExtraFrameScoreIgnored() {

    }


}
