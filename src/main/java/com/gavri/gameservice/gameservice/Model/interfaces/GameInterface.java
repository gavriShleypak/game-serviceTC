package com.gavri.gameservice.gameservice.Model.interfaces;

import com.gavri.gameservice.gameservice.DataModel.GameDetailsDM;

public interface GameInterface {

    GameDetailsDM requestLogicChanges(GameDetailsDM gameStatus);
}
