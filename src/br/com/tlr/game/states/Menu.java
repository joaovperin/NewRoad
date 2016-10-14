/*
 * TestLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.game.states;

import br.com.tlr.graphics.ui.Button;
import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Estado -> Menu
 */
public class Menu extends BasicGameState {

    /** Plano de fundo */
    private Image background;
    /** Fonte padrão para escrever textos */
    private Font texto;

    private Image btImg;

    //https://sourceforge.net/p/jmmorpg/code/HEAD/tree/JMMORPG/src/game/cliente/core/PathFinder.java#l6
    //http://xswing.net/?page_id=6
    //http://slick.ninjacave.com/forum/viewtopic.php?t=3436
    //nifty slick2d example

    /** Botão play */
    private Button btPlay;
    // Utilizar Nifty GUI
    // https://sourceforge.net/projects/nifty-gui/files/latest/download
    // http://pontov.com.br/site/java/48-java2d/327-criando-uma-interface-ao-usuario-usando-nifty-gui
    // https://docs.jmonkeyengine.org/advanced/nifty_gui.html
    // http://vimeo.com/25637085


    // Try alternatives like Nifty GUI which is compatible with slick
    // Pesquisar por Slick2D button no google
    // Ler http://stackoverflow.com/questions/17970481/slick2d-gui-button-listener
    // https://www.youtube.com/watch?v=lLYzToAaGQQ

    @Override
    public int getID() {
        return 0;
    }

    /**
     * Carrega as imagens e as animações
     *
     * @param container Container do jogo
     * @param game
     * @throws SlickException Problema no carregamento dos objetos na API
     */
    @Override
    public void init(GameContainer gc, StateBasedGame game) throws SlickException {
        background = new Image("data/menu/bg-squares-3d.jpg");
        texto = new AngelCodeFont("org/newdawn/slick/data/defaultfont.fnt", "org/newdawn/slick/data/defaultfont.png");
        btImg = new Image("data/menu/bt1.png");
        btPlay = new Button("oie hehe", (gc.getWidth() / 2), gc.getHeight() / 15 + 50, 250f, 40f);
        btPlay.load(gc);
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
        Input input = container.getInput();

        btPlay.update(container, delta);
        int x = 0;
        int y = 0;

        String msg = "  --- ";
        if(input.getMouseX() > x && input.getAbsoluteMouseY() > y && input.getMouseX() < x + btImg.getWidth()
            && input.getMouseY() < y + btImg.getHeight()){
            msg = "em cima do bt";
        }
        System.out.println(msg);
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
        background.draw();
        btImg.draw();
        texto.drawString(150f, 50f, "TESTE STRING", Color.yellow);
        btPlay.render(container, g);
//        btPlay.p
    }

}
