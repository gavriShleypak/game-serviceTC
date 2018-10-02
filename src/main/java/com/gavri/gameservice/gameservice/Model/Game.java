package com.gavri.gameservice.gameservice.Model;

import com.gavri.gameservice.gameservice.DataModel.GameDetailsDM;
import com.gavri.gameservice.gameservice.Model.interfaces.GameInterface;
import com.gavri.gameservice.gameservice.Model.interfaces.PlayerInterface;

public class Game  implements GameInterface {

    private Board mBoard;
    private PlayerInterface mFirst;
    private PlayerInterface mSecond;
    private boolean mBot = false;

    public Game(){

        mBoard = new Board();
        mFirst = new RPlayer(Player.PlayerSign.X);
        mSecond = new RPlayer(Player.PlayerSign.O);
    }

    @Override
    public GameDetailsDM requestLogicChanges(GameDetailsDM gameStatus) {
        int x = gameStatus.getX();
        int y = gameStatus.getY();
        char player = gameStatus.getCurrentPlayer();


        if (gameStatus.getStatus().equals("NewGame")) {
            startNewGame();
        } else {

            postToPlayerDetail(x, y, getPlayerSign(player));

            Player.Move move = getCurrentPlayer().getMove();

            if (checkMove(move.getX(), move.getY(), player)) {
                if (mBoard.IsWinner()) {
                    gameStatus.setWinner(player);
                }
                gameStatus.setValidMove(true);
                if(mBoard.isTie()){
                    gameStatus.setStatus("Tie");
                }

            } else {
                gameStatus.setValidMove(false);
            }
        }
        return gameStatus;
    }

    private PlayerInterface getCurrentPlayer(){
        if(mBoard.getCurrentPlayer() == Player.PlayerSign.X){
            return mFirst;
        }
        else{
            return mSecond;
        }
    }

    private void postToPlayerDetail(int i_x, int i_y, Player.PlayerSign player){
        if(player == Player.PlayerSign.X){
            mFirst.InsertMove(i_x, i_y);
        }
        else{
            mSecond.InsertMove(i_x, i_y);
        }
    }

    private void startNewGame() {
        mBoard = new Board();
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



