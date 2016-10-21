/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tlr.elements;

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
import org.newdawn.slick.geom.RoundedRectangle;
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

    float height;
    float width;

    /** Gerenciador de inputs */
    protected InputProvider provider;
    /** Objeto responsável pelo gerenciamento de comandos */
    protected Comandos comandos = new Comandos();

    Image img;



    /**
     * Construtor padrão para instanciar todas as dependências
     *
     * @throws SlickException Problema ao instanciar dependências
     */
    public Player() throws SlickException {
        img = new Image("data/sprites/wmg1-rt1.png");
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
        me.get().setAutoUpdate(true);
//        current = new Animation(true);
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
//        current.update(delta);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
//        current.draw(getX(), getY());
        Input input = container.getInput();
//        img.draw(getX(), getY());
        me.get().draw(getX(), getY()); // DRAW
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

    @Override
    public void controlPressed(Command cmd) {
        if(comandos.setComandos(cmd)){
            me.get().setAutoUpdate(true);
        }
    }

    @Override
    public void controlReleased(Command cmd) {
        if (comandos.unsetComandos(cmd)){
            me.get().setAutoUpdate(false);
        }
    }

    /**
     * COLOCAR NA SUPER CLASSE (DEPOIS):
     */

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
        return new RoundedRectangle(getX() + 8, getY() + 40, width, height , 30f);
    }


}
