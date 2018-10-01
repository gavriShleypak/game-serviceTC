package com.gavri.gameservice.gameservice.Model;

public class Board {


    private static final int BOARD_SIZE = 3;
    private Square[][] mBoard = new Square[BOARD_SIZE][BOARD_SIZE];
    private Player.PlayerSign mPlayerToMove;
    private Player.PlayerSign mGameWinner;
    private boolean mGameIsComplete;
    private int mEmptySquares = BOARD_SIZE * BOARD_SIZE;

    public Board(){
        mPlayerToMove = Player.PlayerSign.X;
        mGameIsComplete = false;
        initializeBoard();
    }

    private void initializeBoard(){
        for (int i = 0; i < BOARD_SIZE; i++){
            for (int j = 0; j<BOARD_SIZE; j++){
                mBoard[i][j] = new Square();
            }
        }
    }

    public void NextMove(){
        if(mPlayerToMove == Player.PlayerSign.X) {
            this.mPlayerToMove = Player.PlayerSign.O;
        }
        else{
            this.mPlayerToMove = Player.PlayerSign.X;
        }
    }

    public boolean IsWinner(){
        return mGameIsComplete;
    }
// this method gets a coordinates

    public boolean InsertMove(int x, int y , Player.PlayerSign i_sign) {

        boolean res = false;

        if (mPlayerToMove == i_sign) {
            if (mBoard[x][y].isEmpty()) {
                mBoard[x][y].setSign(getCellSign(i_sign));


                if (checkWinner(x, y, i_sign)) {
                    setWinner(i_sign);
                } else {
                    NextMove();
                }
                /// send to the FE that someone win
                mEmptySquares--;
                res = true;
            }
        }
        return res;
    }

    public boolean isTie(){
        return mEmptySquares == 0;
    }

    private void setWinner(Player.PlayerSign i_sign){
        mGameWinner = i_sign;
        mGameIsComplete = true;
    }

    // for now i scan the board and return the right answer
    private boolean checkWinner(int x , int y, Player.PlayerSign i_sign){

        return isTInRow(x, i_sign) || isTInCol(y, i_sign) || isTInDiagonal(x, y, i_sign);

    }

    private boolean isTInRow(int x, Player.PlayerSign i_sign){

        Square.CellSign sign = getCellSign(i_sign);

        return mBoard[x][0].getSign() ==  sign && mBoard[x][1].getSign() == sign && mBoard[x][2].getSign() == sign;

    }

    private boolean isTInCol(int y, Player.PlayerSign i_sign){

        Square.CellSign sign = getCellSign( i_sign);

        return (mBoard[0][y].getSign() == sign && mBoard[1][y].getSign() == sign && mBoard[2][y].getSign() == sign);

    }

    private boolean isTInDiagonal(int x, int y, Player.PlayerSign i_sign){

        Square.CellSign sign = getCellSign(i_sign);
// check the second diagonal.

        if(x == y){
            return mBoard[0][0].getSign() == sign && mBoard[1][1].getSign() == sign && mBoard[2][2].getSign() == sign;
        }
        else{
            return mBoard[0][2].getSign() == sign && mBoard[1][1].getSign() == sign && mBoard[2][0].getSign() == sign;
        }
    }

    private Square.CellSign getCellSign(Player.PlayerSign i_sign){
        if(i_sign == Player.PlayerSign.X){
            return Square.CellSign.X;
        }
        else {
            return Square.CellSign.O;
        }
    }


}
