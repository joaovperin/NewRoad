/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tlr.elements;

import br.com.tlr.encapsulation.AnimationEnum;
import br.com.tlr.factory.AnimationFactory;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProvider;
import org.newdawn.slick.command.InputProviderListener;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author JOAO
 */
public class Player3 extends Character implements InputProviderListener {

    /** The input provider abstracting input */
    private InputProvider provider;

    // https://github.com/dmitrykolesnikovich/featurea/tree/master/engines/platformer
    Shape shape = new Circle(0f, 0f, 25f);
    Vector2f mPos = new Vector2f();
    Borda tst = new Borda();

    /** Objeto responsável pelo gerenciamento de comandos */
    Comandos comandos = new Comandos();

    /**
     * Construtor padrão de um Player
     *
     * @param animationName Nome do arquivo de animações do jogador
     * @param numFrames Número de frames por sprite
     * @param movableArea Dimensões máximas do jogador
     */
    public Player3(String animationName, int numFrames, float[][] movableArea) {
        super(animationName, numFrames, movableArea);
    }

    /**
     * Carrega as imagens e as animações
     *
     * @param container Container do jogo
     * @throws SlickException Problema no carregamento dos objetos na API
     */
    @Override
    public void load(GameContainer container) throws SlickException {
        // Instancia InputProvider do Player
        provider = new InputProvider(container.getInput());
        provider.addListener(this);
        // Amarra comandos no gerenciador InputProvider
        comandos.bindComandos(provider);
        // Cria e carrega as animações
        animacoes = AnimationFactory.create(animationName, 4, AnimationEnum.getAll());
        animacoes.load(container);
        // Inicializa o character movendo virado para a esquerda
        animacoes.init(AnimationEnum.LEFT);
    }

    /**
     * Atualiza os frames do jogo
     *
     * @param gc Container do jogo
     * @param delta Tempo de atualização
     * @throws SlickException Problema ao atualizar quadros
     */
    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        // Entradas do jogo
        Input input = gc.getInput();
        mPos.x = input.getAbsoluteMouseX();
        mPos.y = input.getAbsoluteMouseY();

        if (this.isCollidingWith(tst)){
            System.out.println("Collide!");
        } else System.out.println();

        animacoes.stop();
//        System.out.println("Key: " + AnimationEnum.getByName(Keyboard.getKeyName(Keyboard.getEventKey())).test()); // USAR ISSO PRA DETECTAR O MOVIMENTO
//        AnimationEnum.getByName(Keyboard.getKeyName(Keyboard.getEventKey())).test();
        // Ações de movimentação - DOWN
        if (comandos.isDownCmd() && comandos.canMoveDown(getY(), movableArea[1][1])) {
            animacoes.setCurrent(AnimationEnum.DOWN);
            addY(delta * 0.1f);
        }
        // Ações de movimentação - LEFT
        if (comandos.isLeftCmd() && comandos.canMoveLeft(getX(), movableArea[0][0])) {
            animacoes.setCurrent(AnimationEnum.LEFT);
            subX(delta * 0.1f);
        }
        // Ações de movimentação - RIGHT
        if (comandos.isRightCmd() && comandos.canMoveRight(getX(), movableArea[0][1])) {
            animacoes.setCurrent(AnimationEnum.RIGHT);
            addX(delta * 0.1f);
        }
        // Ações de movimentação - UP
        if (comandos.isUpCmd() && comandos.canMoveUp(getY(), movableArea[1][0])) {
            animacoes.setCurrent(AnimationEnum.UP);
            subY(delta * 0.1f);
        }
//        animacoes.changePosition(pos);
    }

    /**
     * Renderiza as imagens do jogo
     *
     * @param gc Container do jogo
     * @param g Contexto gráfico usado para renderizar o canvas
     * @throws SlickException Problema na renderização de imagens na API
     */
    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        // Entradas do jogo
        Input input = gc.getInput();
        mPos.x = input.getAbsoluteMouseX();
        mPos.y = input.getAbsoluteMouseY();
        // Se deve atacar
        if (comandos.isAtkCmd()) {
            shape.setCenterX(mPos.x);
            shape.setCenterY(mPos.y);
            g.fill(shape);
        }
        g.fill(tst.getTst());
        // Move e renderiza as animações
        animacoes.move(pos);
        animacoes.render(gc, g);
    }

    /**
     * Callback de comando pressionado
     *
     * @param command
     */
    @Override
    public void controlPressed(Command command) {
        comandos.setComandos(command);
    }

    /**
     * Callback de comando solto
     *
     * @param command
     */
    @Override
    public void controlReleased(Command command) {
        comandos.unsetComandos(command);
    }

    /**
     * Método responsável por detectar colisões
     *
     * @param obj
     * @return
     */
    @Override
    public boolean isCollidingWith(SpacialElement obj) {

//        http://blog.sklambert.com/html5-canvas-game-2d-collision-detection/
//        if (object1.x < object2.x + object2.width  && object1.x + object1.width  > object2.x &&
//		object1.y < object2.y + object2.height && object1.y + object1.height > object2.y) {
// The objects are touching
//}

        // Verifica se está ocorrendo colisão
        return getX() < obj.getX() + obj.getWidth() && getX() + getWidth() > obj.getX() &&
                getY() < obj.getY() + obj.getHeight() && getY() + getHeight() > obj.getY();
    }

    private class Borda extends Movable {
        Shape tst;

        public Borda() {
            tst = new Circle(100f, 100f, 25f);
            setX(100f);
            setY(100f);
            setHeight(25);
            setWidth(25);
        }

        public Shape getTst(){
//            System.out.println("X: " + getX() + " Y: " + getY());
            return tst;
        }

    }

}
