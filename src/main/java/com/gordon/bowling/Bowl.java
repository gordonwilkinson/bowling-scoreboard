package com.gordon.bowling;

import com.gordon.bowling.services.ConsoleService;
import com.gordon.bowling.services.GameService;
import com.gordon.bowling.services.ScoreboardService;

/**
 * Created by gordonwilkinson on 2018-12-08.
 */
public class Bowl {

    public static void main(String[] args) {
        GameService gameService = new GameService(new ConsoleService(), new ScoreboardService());
        gameService.playGame();
    }
}
