/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tlr.elements;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProvider;
import org.newdawn.slick.command.InputProviderListener;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author 0199831
 */
public class Player extends MovableElement implements InputProviderListener {

    /** Inventário */
    Inventory inventario;
    /** Itens equipados */
    Equipped equipped;

    /** Gerenciador de inputs */
    protected InputProvider provider;
    /** Objeto responsável pelo gerenciamento de comandos */
    protected Comandos comandos = new Comandos();

    Image img;

    Animation current;
    Animation up;
    Animation down;
    Animation left;
    Animation right;

    /**
     * Construtor padrão para instanciar todas as dependências
     *
     * @throws SlickException Problema ao instanciar dependências
     */
    public Player() throws SlickException {
        img = new Image("data/sprites/wmg1-rt1.png");
    }

    @Override
    public void load(GameContainer container) throws SlickException {
        provider = new InputProvider(container.getInput()); // Ver. possibilidade de tornar singleton.
        provider.addListener(this);
        // Amarra comandos no gerenciador InputProvider
        comandos.bindComandos(provider);
        canMove = true;
//        current = new Animation(true);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        Input input = container.getInput();

        if (comandos.isDownCmd()) {
            dy = -2;
        }
        if (comandos.isUpCmd()) {
            dy = 2;
        }
        if (comandos.isLeftCmd()) {
            dx = -2;
        }
        if (comandos.isRightCmd()) {
            dx = 2;
        }

        if (input.isKeyPressed(Input.KEY_SPACE)) {
            canMove = !canMove;
        }
        if (input.isKeyPressed(Input.KEY_W)) {
            dy = -2;
        }
        if (input.isKeyPressed(Input.KEY_S)) {
            dy = 2;
        }
        if (input.isKeyPressed(Input.KEY_A)) {
            dx = -2;
        }
        if (input.isKeyPressed(Input.KEY_D)) {
            dx = 2;
        }
        move();
//        current.update(delta);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
//        current.draw(getX(), getY());
        Input input = container.getInput();
        img.draw(getX(), getY());
        // Se deve atacar
        Shape shape = new Circle(0f, 0f, 25f);
        if (comandos.isAtkCmd()) {
            shape.setCenterX(input.getAbsoluteMouseX());
            shape.setCenterY(input.getAbsoluteMouseY());
            g.setColor(Color.yellow);
            g.fill(shape);
        }
    }

    @Override
    public void controlPressed(Command cmd) {
        comandos.setComandos(cmd);
    }

    @Override
    public void controlReleased(Command cmd) {
        comandos.unsetComandos(cmd);
    }

}
