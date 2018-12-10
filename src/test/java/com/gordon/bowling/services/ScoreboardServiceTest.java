package com.gordon.bowling.services;

import com.gordon.bowling.model.Frame;
import com.gordon.bowling.model.Scoreboard;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by gordonwilkinson on 2018-12-09.
 */
public class ScoreboardServiceTest {

    private Scoreboard scoreboard;

    private ScoreboardService scoreboardService;

    @Before
    public void init() {
        scoreboard = new Scoreboard();
        scoreboardService = new ScoreboardService(scoreboard);
    }


    @Test
    public void addFrame() throws Exception {
        Frame frame = scoreboardService.addFrame(1,1,1,1);
        assertThat(frame, is(notNullValue()));
    }

    @Test
    public void verifyFrameLink () throws Exception {
        Frame frameParent = scoreboardService.addFrame(1,1,1,1);
        Frame frame = scoreboardService.addFrame(1,1,1,2);
        assertThat(frame.getPrevious(), is(frameParent));
    }

    @Test
    public void getGameScore() throws Exception {
        Frame frameParent = scoreboardService.addFrame(1,1,1,1);
        Frame frame = scoreboardService.addFrame(1,1,1,2);
        assertThat(frame.getPrevious(), is(frameParent));

    }

    @Test
    public void getFrameScore() throws Exception {
        Frame frame = scoreboardService.addFrame(1,1,1,1);
        assertThat(frame.getFrameScore(), is(3));
    }

    @Test
    public void verifyStrikeFrame() throws Exception {
        Frame frame = scoreboardService.addFrame(10,0,0,1);
        assertThat(frame.isStrikeFrame(), is(true));
    }
    @Test
    public void verifySpareFrame() throws Exception {
        Frame frame = scoreboardService.addFrame(7,3,0,1);
        assertThat(frame.isSpareFrame(), is(true));
    }
}