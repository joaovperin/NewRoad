/*
 * TestLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.game.states;

import br.com.tlr.elements.Player3;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Descrição da classe.
 */
public class LevelGrass extends BasicGameState {

    /** Mapa principal do jogo -> Grama */
    private TiledMap grassMap;
    /** Jogador */
//    private Player player;
    /** Jogador 2 */
//    private Player2 player2;
    /** Jogador 3 */
    private Player3 player3;

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
        // Instancia e carrega sprites e animações do jogador 3
        player3 = new Player3("player.png", 4, movableArea);
        player3.load(container);
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
        // Atualiza os jogadores
//        player.update(container, delta);
//        player2.update(container, delta);
        player3.update(container, delta);
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
        // Renderiza o mapa e os jogadores
        grassMap.render(0, 0);
//        player.render(container, g);
//        player2.render(container, g);
        player3.render(container, g);

    }

}
