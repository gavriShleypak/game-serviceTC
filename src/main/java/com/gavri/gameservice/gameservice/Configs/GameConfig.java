package com.gavri.gameservice.gameservice.Configs;


import com.gavri.gameservice.gameservice.DataModel.GameDetailsDM;
import com.gavri.gameservice.gameservice.DataModel.GameDetailsDMInterface;
import com.gavri.gameservice.gameservice.Model.Game;
import com.gavri.gameservice.gameservice.Model.interfaces.GameInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// configurate singelton of Dama model and instance of the game
@Configuration
public class GameConfig {

    @Bean
    public GameDetailsDMInterface GameDetails(){
        return new GameDetailsDM();
    }

    @Bean
    public GameInterface game(){
        return new Game();
    }


}
