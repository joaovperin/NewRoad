/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tlr.elements;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author 0199831
 */
public class Player extends MovableElement {

    /** Inventário */
    Inventory inventario;
    /** Itens equipados */
    Equipped equipped;

    Image img;

    Animation current;
    Animation up;
    Animation down;
    Animation left;
    Animation right;

    @Override
    public void load(GameContainer container) throws SlickException {
        img = new Image("data/sprites/wmg1-rt1.png");
        canMove = true;
//        current = new Animation(true);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        Input input = container.getInput();
        if (input.isKeyPressed(Input.KEY_SPACE)) canMove = !canMove;
        if (input.isKeyPressed(Input.KEY_W)) dy = -2;
        if (input.isKeyPressed(Input.KEY_S)) dy = 2;
        if (input.isKeyPressed(Input.KEY_A)) dx = -2;
        if (input.isKeyPressed(Input.KEY_D)) dx = 2;
        move();
//        current.update(delta);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
//        current.draw(getX(), getY());
        img.draw(getX(), getY());
    }

}
