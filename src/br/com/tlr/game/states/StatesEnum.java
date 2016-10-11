/*
 * TestLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.game.states;

import org.newdawn.slick.state.BasicGameState;

/**
 * Game state identifiers
 */
public enum StatesEnum {

    MENU(null), INVENTORY(null), GAMEPLAY(new GamePlay()), GAMEOVER(null);

    /**
     * Estado
     */
    private final BasicGameState state;

    /**
     * Construtor padrão do estado
     */
    private StatesEnum(BasicGameState state) {
        this.state = state;
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
