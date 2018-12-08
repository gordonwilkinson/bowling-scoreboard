bowling-scoreboard
=============================

A program, which, given a valid sequence of rolls for one line of American Ten-Pin Bowling, produces the total score for the game.

### Data Requirements / API Definition

### References:
The following video is a good overview if you are not familiar with American Ten-Pin Bowling: https://www.youtube.com/watch?v=E2d8PizMe-8.

### American Ten-Pin Bowling Scoring Rules

- The game consists of 10 frames.

- In each frame the player has two opportunities to knock down 10 pins.

- The score for the frame is the total number of pins knocked down, plus bonuses for strikes and spares.

    #### Spares
    A spare is when the player knocks down all 10 pins in two tries.
    The bonus for that frame is the number of pins knocked down by the next roll. So in frame 3 above, the score is 10 (the total number knocked down) plus a bonus of 5 (the number of pins knocked down on the next roll.)

    #### Strikes
    A strike is when the player knocks down all 10 pins on his first try. The bonus for that frame is the value of the next two balls rolled.

    #### The Tenth(Final) Frame
    In the tenth frame a player who rolls a spare or strike is allowed to roll the extra balls to complete the frame. However no more than three balls can be rolled in tenth frame.


More info on the rules at: www.topendsports.com/sport/tenpin/scoring.htm

### Limitations
Will not check for valid rolls
Will not check for correct number of rolls and frames
Will not provide scores for intermediate frames

