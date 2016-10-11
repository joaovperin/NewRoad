/*
 * TestLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.game.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Estado -> GamePlay
 */
public class GamePlay extends BasicGameState {

    @Override
    public int getID() {
        return 2;
    }
    
    

    /**
     * Carrega as imagens e as animações
     *
     * @param container Container do jogo
     * @param game
     * @throws SlickException Problema no carregamento dos objetos na API
     */
    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {

    }

    /**
     * Atualiza os frames do jogo
     *
     * @param container Container do jogo
     * @param game
     * @param delta Tempo de atualização
     * @throws SlickException Problema ao atualizar quadros
     */
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

    }

    /**
     * Renderiza as imagens do jogo
     *
     * @param container Container do jogo
     * @param game
     * @param g Contexto gráfico usado para renderizar o canvas
     * @throws SlickException Problema na renderização de imagens na API
     */
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {

    }

}
