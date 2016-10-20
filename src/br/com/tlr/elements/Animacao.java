/*
 * NewRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.elements;

import br.com.tlr.interfaces.Renderable;
import java.util.Map;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Descrição da classe.
 */
public class Animacao implements Renderable {

    /**
     * Set de animações do jogador
     */
    protected Animation current;

    private final String SPRITES_DIR = "";

    protected Map<String, Animation> animacoes;
    SpriteSheet sheet;
    protected Animation up;
    protected Animation down;
    protected Animation left;
    protected Animation right;

    private final String name;
    private final int wid;
    private final int hei;



    // constantes pra ajeitar depois:
    private static final int x0 = 0;
    private static final int x1 = 0;
    private static final int y0 = 0;
    private static final int y1 = 0;


    public Animacao(String name, int wid, int hei) {
        this.name = name;
        this.wid = wid;
        this.hei = hei;
    }

    @Override
    public void load(GameContainer gc) throws SlickException {
        //Carrega sprites para as animações de movimentos
        sheet = new SpriteSheet(SPRITES_DIR + name, wid, hei);
        current = new Animation(sheet, x0, y0, x1, y1, true, 200, true);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {

    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
//        current.draw();
    }

    public Animation get(){
        return current;
    }

}
