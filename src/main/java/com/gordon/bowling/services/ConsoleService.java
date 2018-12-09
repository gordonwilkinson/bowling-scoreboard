package com.gordon.bowling.services;

import com.gordon.bowling.model.GameTypeParams;
import org.springframework.stereotype.Service;

import java.util.Scanner;

/**
 * Created by gordonwilkinson on 2018-12-08.
 */

@Service
public class ConsoleService {

    private final String EXIT_ENTRY = "exit";
    private final String STRIKE_ENTRY = "x";
    private int[][] scores;

    public Scanner commandLine;

    public ConsoleService() {
        this.commandLine = new Scanner(System.in);
    }

    public int[][] getFrameScores(int[][] scoreTemplate) {
        this.scores = scoreTemplate;
        promptForScores();
        return scores;
    }

    private int[][] promptForScores() {
        System.out.println("Please enter scores for each frame requested. ");
        System.out.println("Type exit to terminate your request - all input will be discarded. ");
        System.out.println("For a score of zero hit enter. ");
        System.out.println("For a strike hit x. ");

        boolean running = true;
        int numFrames = scores.length;
        int currentFrameNum = 1;
        final String regex = "\\d+";

        frameCheck:
        for (int frameCnt = 0; frameCnt < numFrames; frameCnt++) {
            roundCheck:
            for (int round = 0; round < scores[frameCnt].length; round++) {
                System.out.println(String.format("Enter score for frame#: %s round#: %s.", frameCnt + 1, round + 1));

                String inputValue = commandLine.nextLine().trim().toLowerCase();
                String score = inputValue.isEmpty() ? "0" : inputValue.equals(STRIKE_ENTRY) ? Integer.toString(GameTypeParams.TEN_PIN.getStrikeValue()) : inputValue;

                if (inputValue.equals(EXIT_ENTRY)) {
                    System.out.println("Score entry terminated on request.");
                    break frameCheck;
                }

                if (inputValue.equals(STRIKE_ENTRY)  && frameCnt < scores.length - 1) {
                    scores[frameCnt][round] = GameTypeParams.TEN_PIN.getStrikeValue();
                    break roundCheck;
                }

                if (!score.matches(regex)) {
                    System.out.println("You entered an invalid score. Score entry terminated.");
                    break frameCheck;
                }

                scores[frameCnt][round] = Integer.parseInt(score);
            }
        }

        commandLine.close();
        return scores;
    }
}
