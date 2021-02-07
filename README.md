# 3-Card Poker

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

