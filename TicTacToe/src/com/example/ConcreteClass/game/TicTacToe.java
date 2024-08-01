package com.example.ConcreteClass.game;

import com.example.ConcreteClass.Pieces.*;
import com.example.ConcreteClass.Players.Player;
import com.example.ConcreteClass.board.Board;
import com.example.enums.PieceType;
import java.util.*;

public class TicTacToe{
    Board gameBoard;
    Deque<Player> players;
    int BoardSize;

    public void initializeGame() {
        
        players = new LinkedList<>();
        int playerCount;

        // Taking integer input
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter number of players: ");
            playerCount = scanner.nextInt();
            if(playerCount>5 || playerCount<2) {
                System.out.println("Player count must be between 2 to 5");
            } else {
                break;
            }
        }
        BoardSize = playerCount+1;


        players.add(new Player(takeInput(1), 1, new PlayingPieceO()));
        players.add(new Player(takeInput(2), 2, new PlayingPieceW()));
        if(playerCount>2) players.add(new Player(takeInput(3), 3, new PlayingPiece$()));
        if(playerCount>3) players.add(new Player(takeInput(4), 4, new PlayingPieceX()));
        if(playerCount>4) players.add(new Player(takeInput(5), 5, new PlayingPieceY()));

        // Initialize board
        gameBoard = new Board(BoardSize);
    }

    String takeInput(int id) {
        System.out.print("Enter name of player-"+id+":  ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        return name;
    }

    public String startGame() {
        boolean noWinner = true;
        while(noWinner) {

            //Check free space availibility
            if(gameBoard.getNumberOfFreePositions()==0) {
                noWinner = true;
                continue;
            }

            //Take the current player and add that in last
            Player curPlayer = players.removeFirst();

            //Take input
            System.out.println("\n\n====================");
            System.out.println("Current Board: ");
            gameBoard.printBoard();
            System.out.println("Its player-"+curPlayer.getId()+" "+curPlayer.getName()+"'s turn");
            System.out.println("Your piece is "+curPlayer.getPlayingPiece().getPlayingPieceType());
            System.out.print("Enter row, column (count starts with 0): ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int row = Integer.valueOf(values[0]);
            int column = Integer.valueOf(values[1]);

            //Place the piece
            boolean addPieceInBoard = gameBoard.addPiece(row, column, curPlayer.getPlayingPiece());
            if(!addPieceInBoard) {
                System.out.println("Position is not correct, please try again");
                players.addFirst(curPlayer);
                continue;
            }
            players.addLast(curPlayer);

            boolean winner = isThereWinner(row, column, curPlayer.getPlayingPiece().getPlayingPieceType());

            if(winner) return curPlayer.getName();
        }
        return "tie";
    }

    private boolean isThereWinner(int row, int column, PieceType curPieceType) {
        Boolean rowMatchFront = true;
        Boolean rowMatchBack = true;
        Boolean colMatchUp = true;
        Boolean colMatchDown = true;
        Boolean diaMatchFront = true;
        Boolean diaMatchBack = true;

        if(row+3>BoardSize-1) rowMatchFront = false;
        else {
            for(int i=row; i<row+3; i++) {
                if ( gameBoard.getCurrentPlayingPiece(i, column)==null || 
                    gameBoard.getCurrentPlayingPiece(i, column).getPlayingPieceType() != curPieceType) rowMatchFront = false;
            }
        }

        if(row-2<0) rowMatchBack = false;
        else {
            for(int i=row; i>row-3; i--) {
                if ( gameBoard.getCurrentPlayingPiece(i, column)==null ||
                    gameBoard.getCurrentPlayingPiece(i, column).getPlayingPieceType() != curPieceType) rowMatchBack = false;
            }
        }

        if(column+3>BoardSize-1) colMatchDown = false;
        else {
            for(int i=column; i<column+3; i++) {
                if ( gameBoard.getCurrentPlayingPiece(row, i)==null ||
                     gameBoard.getCurrentPlayingPiece(row, i).getPlayingPieceType() != curPieceType) colMatchDown = false;
            }
        }

        if(column-2<0) colMatchUp = false;
        else {
            for(int i=column; i>column-3; i--) {
                if ( gameBoard.getCurrentPlayingPiece(row, i)==null ||
                     gameBoard.getCurrentPlayingPiece(row, i).getPlayingPieceType() != curPieceType) colMatchUp = false;
            }
        }

        if(row-2<0 || column-2<0) diaMatchBack = false;
        else {
            for(int i=row, j=column; i>row-3 && j>column-3; i--,j--) {
                if ( gameBoard.getCurrentPlayingPiece(i, j)==null || 
                     gameBoard.getCurrentPlayingPiece(i, j).getPlayingPieceType() != curPieceType) diaMatchBack = false;
            }
        }

        if(row+3>BoardSize-1 || column+3>BoardSize-1) diaMatchFront = false;
        else {
            for(int i=row, j=column; i<row+3 && j<column+3; i++,j++) {
                if ( gameBoard.getCurrentPlayingPiece(i, j)==null || 
                     gameBoard.getCurrentPlayingPiece(i, j).getPlayingPieceType() != curPieceType) diaMatchFront = false;
            }
        }


        return rowMatchBack || rowMatchFront || colMatchDown || colMatchUp || diaMatchBack || diaMatchFront;
        
    }
};