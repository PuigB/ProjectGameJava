import Game.Game;

import java.io.IOException;


public class Main
{
    public static void main(String[] args) throws Exception
    {
        Game game = Game.getGameInstance();
        game.StartGame();
    }
}

// cree 2 perso pouvoir les faire combatre / attaquer / se défendre ( pas de attack = pv -10 )  la fonction attaque trigger la fonction défense
// inventaire
