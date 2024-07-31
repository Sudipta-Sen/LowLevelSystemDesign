package com.example.ConcreteClass.game;

import com.example.ConcreteClass.Pieces.PlayingPieceO;
import com.example.ConcreteClass.Players.Player;
import com.example.ConcreteClass.board.Board;
import java.util.*;

public class TicTacToe{
    Board gameBoard;
    Deque<Player> players;

    public void initializeGame() {
        
        Scanner scanner = new Scanner(System.in);
        players = new LinkedList<>();
        int playerCount;

        // Taking integer input
        while(true) {
            System.out.print("Enter number of players: ");
            playerCount = scanner.nextInt();
            if(playerCount>5 || playerCount<2) {
                System.out.println("Player count must be between 2 to 5");
            } else {
                break;
            }
        }
        
        System.out.print("Enter name of the 1st player: ");
        players.add(new Player(scanner.nextLine(), 1, new PlayingPieceO()));
        players.add(new Player(scanner.nextLine(), 2, new PlayingPieceW()));
        if(playerCount>2) players.add(new Player(scanner.nextLine(), 2, new PlayingPiece$()));
        if(playerCount>3) players.add(new Player(scanner.nextLine(), 2, new PlayingPieceX()));
        if(playerCount>4) players.add(new Player(scanner.nextLine(), 2, new PlayingPieceY()));

        gameBoard = new Board(playerCount + 1);
         
        
    }
};