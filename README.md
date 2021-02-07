# 3-Card Poker

This 3-card poker game judge is coded in Java using Maven project manager.

A good exmaple on how to use this application can be found in ThreeCardPokerTest.java source file. This unit test calls the protected constructor and addPlayer methods in the ThreeCardPoker class to setup a game and ascertain the game's outcome.

Calling this application from the Python test runner uses a different constructor in ThreeCardPoker class requiring a STDIN.

All classes starting with "ThreeCard" are designed to work with a 3-card poker game as described in the project's statement while the other files, Card, Suit and Hand should be generic enough to extends to other poker games though not fully tested. With these classes, I attempt to be a object oriented as possible hoping to make this application extendable.

### How to build
#### Prerequisite:

- Java version 8
- Apache Maven version 3.6.3

#### Steps:
1. Clone project from GitHub
   ```
   git clone git@github.com:lukechiam/pokergame.git
   ```
2. Go to project's root directory
   ```
   cd pokergame
   ```
2. On the command line, run
   ```
   mvn clean install
   ```
3. Copy the built Jar file into the Python test runner's directory
   ```
   cp target/pokergame-1.0-SNAPSHOT.jar [Python_Test_Runner_Dir]/pokergame.jar
   ```

### How to run
#### Prerequisite:

- Python version 3.8.2

#### Steps:
1. Confirm the built Jar file is in the same directory as the "run_tests" test runner application
2. On the command line, run
    ```
    python3 run_tests "java -jar pokergame.jar"
    ```

