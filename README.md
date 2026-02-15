https://roadmap.sh/projects/number-guessing-game

# Number Guessing Game

A simple yet engaging command-line number guessing game written in Java. Test your luck and logical skills by guessing the secret number within a limited number of attempts!

## Features

- Three difficulty levels (Easy, Medium, Hard)
- Interactive command-line interface
- Multiple game rounds
- Helpful hints for incorrect guesses
- Clear feedback on remaining attempts

## Prerequisites

- Java Development Kit (JDK) 11 or higher

## Getting Started

### Running the Game

1. **Building from Source**
   ```bash
   # Clone the repository
   git clone https://github.com/Nattyeah/number-guessing-game
   cd number-guessing-game\src
   
   # Compile the code
   javac *.java
   
   # Run the game
   java CLI start <difficulty>
   ```

## Game Commands

### Starting the Game
```bash
java CLI start <difficulty>
```

Available difficulty levels:
- `easy`: 10 attempts
- `medium`: 5 attempts (default)
- `hard`: 3 attempts

### Example
```bash
# Start game on medium difficulty
java CLI start medium
```

## How to Play

1. The game will generate a random number between 1 and 100
2. Enter your guess when prompted
3. You'll receive hints if your guess is too high or too low
4. Try to guess the number before running out of attempts!
5. After each game, choose to play again or quit

## Project Structure

```
number-guessing-game/
├── src/
│   ├── CLI.java           # Command-line interface
│   ├── GameManager.java   # Core game logic
│   └── Difficulty.java    # Difficulty level enum
└── README.md             # This file
```
