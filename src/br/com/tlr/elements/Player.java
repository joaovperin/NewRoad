/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tlr.elements;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
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

    /**
     * Construtor padrão para instanciar todas as dependências
     *
     * @throws SlickException Problema ao instanciar dependências
     */
    public Player() throws SlickException {
        me = new Animacao("player.png", 32, 48);
    }

    @Override
    public void load(GameContainer container) throws SlickException {
        provider = new InputProvider(container.getInput()); // Ver. possibilidade de tornar singleton.
        provider.addListener(this);
        // Amarra comandos no gerenciador InputProvider
        comandos.bindComandos(provider);
        canMove = true;
        me.load(container);
//        me.get().setAutoUpdate(false);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        Input input = container.getInput();
        /**
         * Comandos -> Movimentação do player 1
         */
        if (comandos.isDownCmd()) {
            dy = 2;
            me.set(Animacao.DOWN);
        }
        if (comandos.isUpCmd()) {
            dy = -2;
            me.set(Animacao.UP);
        }
        if (comandos.isLeftCmd()) {
            dx = -2;
            me.set(Animacao.LEFT);
        }
        if (comandos.isRightCmd()) {
            dx = 2;
            me.set(Animacao.RIGHT);
        }
        // Se pressionar espaço, não permite movimento
        if (input.isKeyPressed(Input.KEY_SPACE)) {
            canMove = !canMove;
        }
        move();
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        Input input = container.getInput();
        me.get().draw(getX(), getY());
        // Se deve atacar
        Shape shape = new Circle(0f, 0f, 25f);
        if (comandos.isAtkCmd()) {
            shape.setCenterX(input.getAbsoluteMouseX());
            shape.setCenterY(input.getAbsoluteMouseY());
            g.setColor(Color.yellow);
            g.fill(shape);
        }
        // Se não puder se mover
        if (!canMove) {
            g.setColor(Color.yellow);
            float x = container.getWidth() * 0.625f;
            float y = container.getHeight() * 0.10416f;
            g.drawString("YOU'RE PARALIZED!!", x, y);
            g.setColor(Color.yellow);
            g.drawString("Press SPACE to move again.", x, y + 50f);
        }

    }

    /**
     * Callback default para comando Pressed
     *
     * @param cmd
     */
    @Override
    public void controlPressed(Command cmd) {
        if (comandos.setComandos(cmd)) {
            me.get().setAutoUpdate(true);
        }
    }

    /**
     * Callback default para comando unPressed
     *
     * @param cmd
     */
    @Override
    public void controlReleased(Command cmd) {
        if (comandos.unsetComandos(cmd)) {
            me.get().setAutoUpdate(false);
        }
    }

}
