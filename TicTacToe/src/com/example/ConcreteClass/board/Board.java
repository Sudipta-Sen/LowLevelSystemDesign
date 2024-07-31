package com.example.ConcreteClass.board;

import com.example.AbstractClass.PlayingPiece;

public class Board {
    int size;
    PlayingPiece[][] board; 

    public Board(int n) {
        this.size = n;
        board = new PlayingPiece[n][n];
    }

    public int getSize() { return size; }
    public boolean addPiece(int row, int col, PlayingPiece playingPiece) {
        if ( row<0 || col<0 || row>size-1 || col>size-1 || board[row][col]!=null) return false;
        board[row][col] = playingPiece;
        return true;
    }
    public void printBoard() {
        for(int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                if(board[i][j]!=null) {
                    System.out.print(board[i][j].getPlayingPiece() + "   ");
                } else {
                    System.out.print("    ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }
};