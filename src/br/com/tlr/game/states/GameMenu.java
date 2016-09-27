/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tlr.game.states;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.command.BasicCommand;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.Control;
import org.newdawn.slick.command.InputProvider;
import org.newdawn.slick.command.InputProviderListener;
import org.newdawn.slick.command.MouseButtonControl;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.state.transition.Transition;

/**
 *
 * @author 0199831
 */
public class GameMenu extends BasicGameState implements InputProviderListener {

    /** Background do menu */
    private Image background;

    /** Controle do cursor do mouse */
    private boolean clickedL;
    private boolean clickedR;
    private boolean draw;
    private Circle cursor;

    /** Botão Play Game */
    private Shape shape;
    private Font font;

    /** Transições de entrada e saída do estágio */
    Transition trIn, trOut;

    /** Controles e comandos do Menu principal do jogo */
    private InputProvider provider;
    private final Control mouseLClick = new MouseButtonControl(Input.MOUSE_LEFT_BUTTON);
    private final Command cLeftClick = new BasicCommand("LEFTCLICK");
    private final Control mouseRClick = new MouseButtonControl(Input.MOUSE_RIGHT_BUTTON);
    private final Command cRightClick = new BasicCommand("RIGHTCLICK");

    /**
     * Retorna o ID do estado
     *
     * @return int
     */
    @Override
    public int getID() {
        return 0;
    }

    /**
     * Carrega as imagens e as animações
     *
     * @param gc Container do jogo
     * @param game Game baseado em states
     * @throws SlickException Problema no carregamento dos objetos na API
     */
    @Override
    public void init(GameContainer gc, StateBasedGame game) throws SlickException {
        // Instancia shapes
        cursor = new Circle(5f, 25f, 25f);
        background = new Image("data/menu/bg-squares-3d.jpg");
        shape = new Ellipse((gc.getWidth() / 2), gc.getHeight() / 15 + 50, 300f, 50f);
        font = new AngelCodeFont("org/newdawn/slick/data/defaultfont.fnt", "org/newdawn/slick/data/defaultfont.png");

        // Instancia InputProvider do Player
        provider = new InputProvider(gc.getInput());
        provider.addListener(this);
        provider.bindCommand(mouseLClick, cLeftClick);
        provider.bindCommand(mouseRClick, cRightClick);

        // Cria transições para trocar de State
        trIn = new FadeInTransition(Color.yellow);
        trOut = new FadeOutTransition(Color.red);
        trIn.init(this, game.getState(StatesEnum.GRASS_MAP.getId()));
        trOut.init(this, game.getState(StatesEnum.GRASS_MAP.getId()));
    }

    /**
     * Atualiza os frames do jogo
     *
     * @param gc Container do jogo
     * @param game Game baseado em states
     * @param delta Tempo de atualização
     * @throws SlickException Problema ao atualizar quadros
     */
    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
        Input input = gc.getInput();
        if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            cursor.setRadius(5f);
        } else if (input.isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON)) {
            cursor.setRadius(55f);
        } else {
            cursor.setRadius(25f);
        }
        // Seta o cursor na posição do mouse
        cursor.setCenterX(input.getAbsoluteMouseX());
        cursor.setCenterY(input.getAbsoluteMouseY());
        // Deve desenhar se o cursor do mouse estiver dentro ou interseccionando o botão play
        draw = shape.contains(cursor) || cursor.intersects(shape);
    }

    /**
     * Renderiza as imagens do jogo
     *
     * @param container Container do jogo
     * @param game Game baseado em states
     * @param g Contexto gráfico usado para renderizar o canvas
     * @throws SlickException Problema na renderização de imagens na API
     */
    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        Input input = container.getInput();
        // Posições do mouse
        int mX = input.getAbsoluteMouseX(), mY = input.getAbsoluteMouseY();
        // Renderiza o plano de fundo e desenha os shapes
        background.draw();
        g.setColor(Color.blue);
        g.fill(shape);
        g.draw(shape);
        g.setColor(Color.white);
        g.fill(cursor);
        g.draw(cursor);
        // Renderiza o texto do botão play
        g.setColor(Color.black);
        String clickPlayStr = "Click to play the game";
        g.drawString(clickPlayStr, (shape.getCenterX() - font.getWidth(clickPlayStr) / 2), shape.getCenterY() - font.
                getHeight(clickPlayStr) / 2);
        // Se clicar no botão play com botão esquerdo do mouse, exibe mensagem de trollagem
        if (draw && clickedL) {
            String str = "No, you'll not play this game. ";
            g.setColor(Color.black);
            g.setFont(font);
            g.drawString(str, mX + 10, mY + 5);
            // Se também clicou com o direito, inicia o jogo
            if (clickedR) {
                game.enterState(StatesEnum.GRASS_MAP.getId(), trOut, trIn);
            }
        }
    }

    /**
     * Callback de comando pressionado
     *
     * @param cmd Comando pressionado
     */
    @Override
    public void controlPressed(Command cmd) {
        if (cmd == cLeftClick) {
            clickedL = true;
        }
        if (cmd == cRightClick) {
            clickedR = true;
        }
    }

    /**
     * Callback de comando solto
     *
     * @param cmd Comando solto
     */
    @Override
    public void controlReleased(Command cmd) {
        if (cmd == cLeftClick) {
            clickedL = false;
        }
        if (cmd == cRightClick) {
            clickedR = false;
        }
    }

}
