/*
 * LWJGL_Space_Invaders
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.game.core;

import br.com.tlr.game.states.StatesEnum;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Coração do jogo TheLonelyRoad
 */
public class TheLonelyRoad extends StateBasedGame {

    /** Propriedades da aplicação */
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    public static final int FPS = 60;
    public static final double VERSION = 0.01;

    /**
     * Construtor padrão do game
     */
    public TheLonelyRoad() {
        super("Nome do jogo");
    }

    /**
     * Inicializa o game
     *
     * @param arguments
     */
    public static void main(String[] arguments) {
        try {
            // Descomentar linha abaixo caso não consiga carregar a API (vai cair MUITO o FPS)
//            System.setProperty("org.lwjgl.opengl.Display.allowSoftwareOpenGL", "true");
            AppGameContainer app = new AppGameContainer(new TheLonelyRoad());
            app.setDisplayMode(WIDTH, HEIGHT, false);
            app.setTargetFrameRate(FPS);
            app.setShowFPS(true);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    /**
     * Inicializa lista dos estados do game
     *
     * @param container
     * @throws SlickException
     */
    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        // Carrega lista dos estados
        for (StatesEnum state : StatesEnum.values()){
            this.addState(state.getState());
        }
    }

}
