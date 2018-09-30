package com.gavri.gameservice.gameservice.DataModel;

public class GameDetailsDM  implements GameDetailsDMInterface{

    private char winner;
    private int X;
    private int Y;
    private boolean validMove;
    private char currentPlayer;
    private String Status;


    @Override
    public void setWinner(char winner) {
        this.winner = winner;
    }


    @Override
    public void setStatus(String i_status) {
        this.Status = i_status;
    }

    @Override
    public void setCurrentPlayer(char i_player) {
        this.currentPlayer = i_player;
    }

    @Override
    public void setValidMove(boolean validMove) {
        this.validMove = validMove;
    }

    @Override
    public boolean getValidMove() {
        return this.validMove;
    }

    @Override
    public void setX(int x) {
        this.X = x;
    }

    @Override
    public void setY(int y) {
        this.Y = y;
    }

    @Override
    public int getX() {
        return X;
    }

    @Override
    public int getY() {
        return Y;
    }

    @Override
    public String getStatus() {
        return this.Status;
    }

    @Override
    public char getCurrentPlayer() {
        return this.currentPlayer;
    }

    public char getWinner() {
        return winner;
    }
}
