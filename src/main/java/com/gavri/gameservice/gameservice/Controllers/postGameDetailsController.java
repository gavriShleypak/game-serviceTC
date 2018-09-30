package com.gavri.gameservice.gameservice.Controllers;

import com.gavri.gameservice.gameservice.Model.interfaces.GameInterface;
import org.springframework.beans.factory.annotation.Autowired;
import com.gavri.gameservice.gameservice.DataModel.GameDetailsDM;
import org.springframework.web.bind.annotation.*;

@RestController
public class postGameDetailsController {

    @Autowired
    private GameInterface mGame;

    @CrossOrigin
    //http://localhost:8085/postGameDetails
    @RequestMapping(value = "/postGameDetails", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    public @ResponseBody
    GameDetailsDM postGameDetails(@RequestBody GameDetailsDM request) {

        return mGame.requestLogicChanges(request);
    }

}
