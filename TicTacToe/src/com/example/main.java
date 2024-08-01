package com.example;

import com.example.ConcreteClass.game.TicTacToe;

public class main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.initializeGame();
        String result = game.startGame();
        if(result.equals("tie")) System.out.println("The game tied");
        else System.out.println(result + " is the winner of the game");
    }
}