package com.gavri.gameservice.gameservice.Model;

import com.gavri.gameservice.gameservice.Model.interfaces.PlayerInterface;

public class Player  implements PlayerInterface {

    private PlayerSign mSign;
    private Move mcurrentMove;


    public enum PlayerSign {X, O}

    Player(PlayerSign i_Sign){
        mSign = i_Sign;
    }

    @Override
    public void InsertMove(int i_x, int i_y){
        mcurrentMove = new Move(i_x, i_y);
    }

    @Override
    public Move getMove() {
        return mcurrentMove;
    }

    public class Move{
        private int mX;
        private int mY;

        Move(int i_x, int i_y){
            mX = i_x;
            mY = i_y;
        }

        int getX(){
            return mX;
        }

        int getY(){
            return mY;
        }



    }

}
