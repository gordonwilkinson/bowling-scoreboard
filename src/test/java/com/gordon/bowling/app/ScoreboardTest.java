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

import java.util.ArrayList;
import java.util.List;

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
    public void verifyGamesResults() {
        List<TestCase> testCases = getScoreInputs();

        for (TestCase testCase : testCases) {
            initializeGameSpace();

            int[][] currentScores = testCase.frameScores;
            int expectedScore = testCase.expectedScore;

            new Expectations() {{
                consoleService.getFrameScores((int[][]) any);
                result = currentScores;
            }};

            gameService.playGame();

            System.out.println(String.format("Game score: %s", gameService.getGameScoreResult()));
            assertThat(gameService.getGameScoreResult(), is(expectedScore));
        }
    }

    //TODO extend this by fuzzing the test score arrays
    private List<TestCase> getScoreInputs() {
        List<TestCase> testCases = new ArrayList<>();

        int[][] emptyGameScore = {};

        int[][] zeroScores = {
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0, 0}};

        int[][] perfectScores = {
                {10, 0},
                {10, 0},
                {10, 0},
                {10, 0},
                {10, 0},
                {10, 0},
                {10, 0},
                {10, 0},
                {10, 0},
                {10, 10, 10}};

        int[][] spareScore = {
                {0, 0},
                {0, 0},
                {0, 0},
                {4, 6},
                {10, 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0, 0}};

        int[][] partialGameScore = {
                {0, 0},
                {0, 0},
                {0, 0},
                {4, 6},
                {10, 0},
                {0, 0}};

        int[][] unexpectedScores = {
                {0, 0},
                {0, 0},
                {100, 0},
                {0, 0},
                {100, 0},
                {0, 0},
                {0, 0},
                {101, 0},
                {0, 0},
                {0, 0, 0}};

        int[][] doubleScores = {
                {10, 0},
                {10, 0},
                {10, 0},
                {10, 0},
                {10, 0},
                {10, 0},
                {10, 0},
                {10, 0},
                {10, 0},
                {10, 0},
                {10, 0},
                {10, 0},
                {10, 0},
                {10, 0},
                {10, 0},
                {10, 0},
                {10, 0},
                {10, 0},
                {10, 0},
                {10, 10, 10}};

        testCases.add(new TestCase(emptyGameScore, 0));
        testCases.add(new TestCase(zeroScores, 0));
        testCases.add(new TestCase(spareScore, 30));
        testCases.add(new TestCase(perfectScores, GameTypeParams.TEN_PIN.getPerfectScore()));
        testCases.add(new TestCase(partialGameScore, 30));
        testCases.add(new TestCase(unexpectedScores, 301));
        testCases.add(new TestCase(doubleScores, 600));

        return testCases;
    }

    private void initializeGameSpace() {
        scoreboardService = new ScoreboardService(new Scoreboard());
        gameService = new GameService(consoleService, scoreboardService);
    }

    private class TestCase {
        int[][] frameScores;
        int expectedScore;

        public TestCase(int[][] frameScores, int expectedScore) {
            this.frameScores = frameScores;
            this.expectedScore = expectedScore;
        }
    }

}
