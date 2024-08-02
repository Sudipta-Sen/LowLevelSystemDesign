# TicTacToe Game - Low-Level Design

## Introduction
This project is a low-level design implementation of a TicTacToe game with support for up to 5 players. It’s designed to accommodate a minimum of 2 players, making it versatile for small group play. The game dynamically adjusts the board size based on the number of player.

## Rules
    Player Count: The game supports between 2 and 5 players.

    Board Size: The board size is determined by the number of players, calculated as (number of players + 1) x (number of players + 1).
                For example, with 3 players, the board size will be 4x4.

    Winning Condition: A player wins by aligning three of their symbols consecutively either row-wise, column-wise, or diagonally.

## How to Play

### Setup:
    The game initializes with a specified number of players (between 2 and 5).
    Each player is assigned a unique symbol (e.g., X, O, Y, $, W).

### Turns:
    Players take turns placing their symbol on the board in an empty spot.
    The goal is to be the first to get three of your symbols in a row, column, or diagonal.

### Winning the Game:
    The game automatically checks for a winning condition after each move.
    If a player aligns three of their symbols consecutively, they are declared the winner.
    If no player achieves this before the board is full, the game ends in a draw.

## Cloning the Repository

TicTacToe is under LowLevelSystemDesign repository. You need to clone the LowLevelSystemDesign repository. You can clone this repository using either SSH or HTTPS.

### SSH
git@github.com:Sudipta-Sen/LowLevelSystemDesign.git

### HTTPS
https://github.com/Sudipta-Sen/LowLevelSystemDesign.git

## Compile the code

### Navigate to the ParkingLotDesign folder

cd low-level-system-design/TicTacToe

### Run make to compile the codebase:

make

### Run the main class:

java -cp bin com.example.main

### Clean up the bin directory

make clean