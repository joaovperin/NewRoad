/*
 * TestLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.manager;

import br.com.tlr.elements.Animable;
import br.com.tlr.elements.Heart;
import br.com.tlr.exception.GameOverException;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 * Classe responsável pelo controle de vida dos characters
 */
public class LifeManager implements Animable {

    // IMPLEMENTAR CONTROLE DE POSIÇÃO PARA DESENHAR OS HEARTS

    private int numHearts;
    private final List<Heart> hearts = new ArrayList<>();

    public LifeManager() {
        this(10);
    }

    public LifeManager(int numHearts) {
        this.numHearts = numHearts;
        // Inicializa Hearts
        for (int x=0; x<numHearts; x++) {
            hearts.add(new Heart());
        }
    }

    public void subHeart() throws GameOverException {
        subHearts(1);
    }

    public void subHearts(int numHearts) throws GameOverException {
        this.numHearts -= numHearts;
        if (numHearts <= 0) {
            throw new GameOverException("Você morreu :D");
        }
    }

    public int getNumHearts() {
        return numHearts;
    }

    @Override
    public void load(GameContainer container) throws SlickException {
        for (Heart heart : hearts){
            heart.load(container);
        }
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        for (Heart heart : hearts){
            heart.update(container, delta);
        }
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        for (Heart heart : hearts){
            heart.render(container, g);
        }
    }

}
