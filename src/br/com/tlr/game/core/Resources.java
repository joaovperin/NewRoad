/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tlr.game.core;

import br.com.tlr.interfaces.Singleton;
import br.com.tlr.database.GameStates;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.state.transition.Transition;

/**
 * Gerenciador de recursos do Game
 *
 * @author Joaov
 */
public class Resources implements Singleton {

    /** Instância única - Singleton */
    public static Resources manager;

    /** Estados possíveis do jogo */
    private final List<GameState> states;
    /** Transições de estados */
    private final List<Transition> transitions;
    /** Guarda as animações dos itens */
    private final List<Animation> itens;

    /**
     * Construtor responsável por instanciar todos os parâmetros
     */
    private Resources() {
        itens = new ArrayList<>();
        states = new ArrayList<>();
        transitions = new ArrayList<>();
        init();
    }

    /**
     * Inicializa os parâmetros do Singleton
     */
    private void init() {
        // Inicializa estados do jogo
        for (GameStates gs : GameStates.values()) {
            states.add(gs.getState());
        }
        transitions.add(new FadeInTransition(Color.red, 300));
        transitions.add(new FadeOutTransition(Color.cyan, 700));
    }

    /**
     * Retorna instância singleton do gerenciador de recursos
     *
     * @return Resources
     */
    public static final Resources get() {
        // Se ainda não foi instanciado
        if (manager == null) {
            manager = new Resources();
        }
        return manager;
    }

    /**
     * Retorna a animação do item
     *
     * @param id Id do item
     * @return Animation
     */
    public final Animation getItem(int id) {
        // Se ainda não foi instanciado
        if (itens.get(id) == null) {
            itens.add(id, new Animation());
        }
        return itens.get(id);
    }

    /**
     * Retorna a animação do item
     *
     * @param st Enumerado
     * @return GameState
     */
    public final GameState getState(GameStates st) {
        return states.get(st.getId());
    }

    /**
     *
     * Retorna uma transição a partir do ID
     *
     * @param id
     * @return
     */
    public final Transition getTransition(int id) {
        return transitions.get(id);
    }

}
