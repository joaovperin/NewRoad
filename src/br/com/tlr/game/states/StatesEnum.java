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

    MAINMENU(new GameMenu()), GRASS_MAP(new LevelGrass());
//    , SPLASHSCREEN, MAINMENU, GAME;  Adicionar estes states depois

    /** Estado */
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
