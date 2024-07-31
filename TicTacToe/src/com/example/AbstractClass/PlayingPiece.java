package com.example.AbstractClass;

import com.example.enums.PieceType;

public abstract class PlayingPiece {
    PieceType type;

    public PlayingPiece(PieceType pt) { this.type = pt; }

    public PieceType getPlayingPiece() { return type; }
};