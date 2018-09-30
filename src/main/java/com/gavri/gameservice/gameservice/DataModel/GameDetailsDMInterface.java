package com.gavri.gameservice.gameservice.DataModel;

public interface GameDetailsDMInterface {

    String getStatus();

    void setStatus(String  i_status);

    void setWinner(char i_winner);

    char getWinner();

    int getX();

    int getY();

    void setX(int x);

    void setY(int y);

    void setValidMove(boolean i_validMove);

    boolean getValidMove();

    char getCurrentPlayer();

    void setCurrentPlayer(char i_player);

}
