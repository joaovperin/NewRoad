/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tlr.elements;

import br.com.tlr.interfaces.Element;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.RoundedRectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author 0199831
 */
public class MovableElement extends Element {

    /**
     * Set de animações do elemento
     */
    protected Animacao me;

    protected boolean canMove;
    protected float dx, dy;

    @Override
    public void load(GameContainer container) throws SlickException {

    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {

    }

    protected void move() {
        if (canMove) {
            setX(getX() + dx);
            setY(getY() + dy);
        }
        clear();
    }

    private void clear() {
        dx = 0;
        dy = 0;
    }

    /**
     * Retorna as dimensões dos pés do jogador (para checar colisões)
     *
     * @return Shape
     */
    public Shape getFootBox() {
        return new RoundedRectangle(getX() + 8, getY() + 40, width - 14, height / 6, 30f);
    }

    /**
     * Retorna as dimensões do corpo inteiro do jogador (para checar colisões)
     *
     * @return Shape
     */
    public Shape getHitBox() {
        //TODO(Perin): Conferir / concertar quando for utilizar
        return new RoundedRectangle(getX() + 8, getY() + 40, width, height, 30f);
    }

}
