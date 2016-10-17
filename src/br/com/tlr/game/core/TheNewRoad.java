/*
 * LWJGL_Space_Invaders
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.game.core;

import br.com.tlr.database.GameStates;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Coração do jogo TheNewRoad
 */
public class TheNewRoad extends StateBasedGame {

    /** Propriedades da aplicação */
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    public static final int FPS = 120;
    public static final double VERSION = 0.01;

    /**
     * Construtor padrão do game
     */
    public TheNewRoad() {
        super("The New Road - V" + VERSION);
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
            AppGameContainer app = new AppGameContainer(new TheNewRoad());
            app.setDisplayMode(WIDTH, HEIGHT, false);
            // Determina um limite de quadros por segundo
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
        for (GameStates state : GameStates.values()){
            this.addState(state.getState());
        }
        // Inicializa no menu principal
        this.enterState(GameStates.MENU.getId());
    }

    /**
     * Retorna verdadeiro se está em modo DEBUG
     *
     * @return boolean
     */
    public static final boolean isDebugMode(){
        return false;
    }

}
