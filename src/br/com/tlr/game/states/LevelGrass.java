/*
 * TestLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.game.states;

import br.com.tlr.elements.Animable;
import br.com.tlr.elements.Obstaculo;
import br.com.tlr.elements.Player3;
import br.com.tlr.elements.SpacialElement;
import br.com.tlr.exception.GameOverException;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.state.transition.Transition;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Descrição da classe.
 */
public class LevelGrass extends BasicGameState {

    /** Mapa principal do jogo -> Grama */
    private TiledMap grassMap;

    private final List<Animable> elements = new ArrayList<>();
    /** Transições de entrada e saída do estágio */
    private Transition trIn, trOut;

    @Override
    public int getID() {
        return 1;
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
        // Carrega o mapa em memória
        grassMap = new TiledMap("data/maps/desert.tmx");
        // Área movível do jogador
        float[][] movableArea = {
            { 0, grassMap.getWidth() * 32.0f }, // X axis
            { 0, grassMap.getHeight() * 28.7f } // Y axis
        };
        // Cria transições para trocar de State
        trIn = new FadeInTransition(Color.yellow);
        trOut = new FadeOutTransition(Color.red);
        trIn.init(this, game.getState(StatesEnum.GRASS_MAP.getId()));
        trOut.init(this, game.getState(StatesEnum.GRASS_MAP.getId()));

        // Instancia e carrega sprites e animações do jogador 3
        elements.add(new Player3("player.png", 4, movableArea));
        // Inicializa as entidades animáveis
        for (Animable a : elements) {
            a.load(container);
        }
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
        try {
            // Atualiza as entidades animáveis
            for (Animable a : elements) {
                a.update(container, delta);
            }
            // Se deve encerrar o jogo
        } catch (GameOverException ex) {
            game.enterState(StatesEnum.GAME_OVER.getId(), trOut, trIn);
        }
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
        // Renderiza o mapa
        grassMap.render(0, 0);
        // Renderiza as entidades animáveis
        for (Animable a : elements) {
            a.render(container, g);
        }
    }

}
