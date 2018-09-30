package com.gavri.gameservice.gameservice.Model;

import com.gavri.gameservice.gameservice.DataModel.GameDetailsDM;
import com.gavri.gameservice.gameservice.Model.interfaces.GameInterface;

public class Game  implements GameInterface {

    private Board mBoard;

    public Game(){
        mBoard = new Board();
    }

    @Override
    public GameDetailsDM requestLogicChanges(GameDetailsDM gameStatus) {
        int x = gameStatus.getX();
        int y = gameStatus.getY();
        char player = gameStatus.getCurrentPlayer();

        if(checkMove(x, y, player)){
            if(mBoard.IsWinner()){
                gameStatus.setWinner(player);
            }
            gameStatus.setValidMove(true);

        }
        else{
            gameStatus.setValidMove(false);
        }

        return gameStatus;
    }

    private boolean checkMove(int x, int y, char player) {

        boolean res;

        res = mBoard.InsertMove(x,y, getPlayerSign(player));

        return res;
    }


    private Player.PlayerSign getPlayerSign(char player){
        if(player == 'X'){
            return Player.PlayerSign.X;
        }
        else{
            return Player.PlayerSign.O;
        }
    }

}



