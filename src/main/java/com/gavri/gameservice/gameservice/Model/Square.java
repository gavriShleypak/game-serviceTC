package com.gavri.gameservice.gameservice.Model;

public class Square {

    public enum CellSign {X, O, E};

    private CellSign mSign = CellSign.E;

    public CellSign getSign(){
        return mSign;
    }

    public void setSign(CellSign i_sign){
        mSign = i_sign;
    }

    public boolean isEmpty(){
        if(mSign == CellSign.E){
            return true;
        }
        else{
            return false;
        }
    }

}
