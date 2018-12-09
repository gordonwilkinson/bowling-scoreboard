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
This is a single player game( one line of American Ten-Pin Bowling)
Returns scores according to American Ten-Pin Bowling rules
Unfinished frames will be score as zero points
Any frame scores submitted following the tenth frame will be ignored



Design Document: Bowling Game

<table>
  <tr>
    <td>Name</td>
    <td>Stake</td>
    <td>TDD Approved</td>
    <td>Comments</td>
  </tr>
  <tr>
    <td>Anthony</td>
    <td>Technical Owner</td>
    <td> </td>
    <td></td>
  </tr>
  <tr>
    <td>Gordon</td>
    <td>Design/Implement</td>
    <td></td>
    <td></td>
  </tr>
</table>


# Problem

Create a program, which, given a valid sequence of rolls for one line of American Ten-Pin Bowling, produces the total score for the game.

# Background

The project submission requirement are found in the ‘SDE/SDET - Take Home Test’ document provided.

# Milestones

See the Future Work section for milestones not covered by this TDD.  This TDD outlines the implementation details for the first milestone (M1), which consists of the following:

* 10 Pin bowling ruleset

* Test coverage

# Data Model Mapping

The design uses domain language such as Frame and Scoreboard.   The following glossary will be useful when discussing implementation details:

<table>
  <tr>
    <td>Domain</td>
    <td></td>
  </tr>
  <tr>
    <td>Frame</td>
    <td></td>
  </tr>
  <tr>
    <td>Scoreboard</td>
    <td></td>
  </tr>
</table>


# Implementation Details
![alt text](/bowling_design.png "Class Diagram")

<table>
  <tr>
    <td>Item</td>
    <td>Description</td>
  </tr>
  <tr>
    <td>Bowl</td>
    <td>Entry point main()
Instantiates and runs a GameService instance
gameService() is called to return and display the game score
</td>
  </tr>
  <tr>
    <td>GameService</td>
    <td>Orchestrates and manages the game play</td>
  </tr>
  <tr>
    <td>ConsoleService</td>
    <td>Handles game play I/O.   </td>
  </tr>
  <tr>
    <td>ScoreboardService</td>
    <td>Handles management of the current game’s scoreboard.</td>
  </tr>
  <tr>
    <td>Scoreboard</td>
    <td>Repository for the game’s main entity Frame</td>
  </tr>
  <tr>
    <td>Frame</td>
    <td>Core game entity support game primitives eg.  pin counts and scoring.</td>
  </tr>
</table>


### Wireframes

None

### Screens

Command line only.

# Tasks

<table>
  <tr>
    <td>Task</td>
    <td>Description</td>
    <td>Estimate</td>
  </tr>
  <tr>
    <td>Failing test</td>
    <td>Provide failing tests to drive implementation</td>
    <td></td>
  </tr>
  <tr>
    <td>Scaffold hierarchy</td>
    <td>Code and wire up classes</td>
    <td></td>
  </tr>
  <tr>
    <td>RGR</td>
    <td>Refactor</td>
    <td></td>
  </tr>
</table>


# Future Work

* Improve the integration test coverage by fuzzing the test score array inputs.

* Extend the the design to handle other bowling games and rulesets (eg 5 pin bowling)

* Refactor ConsoleService to extend an abstract class InputService allowing for extensibility.

Bowling Game Design Doc.md
Displaying Bowling Game Design Doc.md.