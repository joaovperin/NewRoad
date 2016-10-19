/*
 * TestLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.database;

import br.com.tlr.game.states.ConfigScreen;
import br.com.tlr.game.states.GameOver;
import br.com.tlr.game.states.GamePlay;
import br.com.tlr.game.states.Menu;
import org.newdawn.slick.state.BasicGameState;

/**
 * Identificadores dos estados possíveis do jogo
 */
public enum GameStates {

    MENU(new Menu()), GAMEPLAY(new GamePlay()), CONFIGSCREEN(new ConfigScreen()), GAMEOVER(new GameOver());

    /**
     * Estado
     */
    private final BasicGameState state;

    /**
     * Construtor padrão do estado
     */
    private GameStates(BasicGameState state) {
        this.state = state;
        System.out.println("BAUSHAUSHAHAJKH");
    }

    /**
     * Retorna o id do estado
     *
     * @return int
     */
    public int getId() {
        return state.getID();
    }

    /**
     * Retorna o estado
     *
     * @return BasicGameState
     */
    public BasicGameState getState() {
        return state;
    }

}
