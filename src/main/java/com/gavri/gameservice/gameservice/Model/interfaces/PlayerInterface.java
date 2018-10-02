package com.gavri.gameservice.gameservice.Model.interfaces;

import com.gavri.gameservice.gameservice.Model.Player;

public interface PlayerInterface {

    void InsertMove(int i_x, int i_y);

    Player.Move getMove();

}
