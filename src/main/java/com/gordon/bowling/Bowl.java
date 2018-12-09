package com.gordon.bowling;

import com.gordon.bowling.model.Scoreboard;
import com.gordon.bowling.services.ConsoleService;
import com.gordon.bowling.services.GameService;
import com.gordon.bowling.services.ScoreboardService;

/**
 * Created by gordonwilkinson on 2018-12-08.
 */
public class Bowl {
    public static void main(String[] args) {
        ScoreboardService scoreboardService = new ScoreboardService(new Scoreboard());
        ConsoleService consoleService = new ConsoleService();

        GameService gameService = new GameService(consoleService, scoreboardService);
        gameService.playGame();
        System.out.println(String.format("Game score: %s", gameService.getGameScoreResult()));
    }
}
