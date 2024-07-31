package com.example.ConcreteClass.Players;

import com.example.AbstractClass.PlayingPiece;

public class Player {
    String name;
    int id;
    PlayingPiece playingPiece;

    public Player(String name, int id, PlayingPiece pt) {
        this.name = name;
        this.id = id;
        this.playingPiece = pt;
    }

    // public void setPlayingPiece(PlayingPiece pt) { this.playingPiece = pt; }
    public PlayingPiece getPlayingPiece() { return playingPiece; }
    public String getName() { return name; }
    public int getId() { return id; }
    
};