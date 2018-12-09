package com.gordon.bowling.services;

import org.springframework.stereotype.Service;

/**
 * Created by gordonwilkinson on 2018-12-08.
 */

@Service
public class ConsoleService {

    private int[][] emptyScore = new int[0][0];

    public int[][] getFrameScores() {
        int[][] scores = promptForScores();

        return scores;
    }

    private int[][] promptForScores() {
        int[][] scores = emptyScore;
        return scores;
    }

}
