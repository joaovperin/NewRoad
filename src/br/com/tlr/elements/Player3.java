/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tlr.elements;

import br.com.tlr.encapsulation.AnimationEnum;
import br.com.tlr.factory.AnimationFactory;
import br.com.tlr.manager.CollisionManager;
import br.com.tlr.manager.LifeManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProvider;
import org.newdawn.slick.command.InputProviderListener;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

/**
 *
 * @author JOAO
 */
public class Player3 extends Character implements InputProviderListener {

    /** The input provider abstracting input */
    private InputProvider provider;
    private final CollisionManager collisionManager = new CollisionManager();
    private final LifeManager lifeManager = new LifeManager();

    // LER ISSO!
    //http://zetcode.com/tutorials/javagamestutorial/collision/
    // https://github.com/dmitrykolesnikovich/featurea/tree/master/engines/platformer
    // https://gamedevelopment.tutsplus.com/tutorials/collision-detection-using-the-separating-axis-theorem--gamedev-169   SAT
//        http://blog.sklambert.com/html5-canvas-game-2d-collision-detection/
    Shape shape = new Circle(0f, 0f, 25f);
    Vector2f mPos = new Vector2f();
    Buraco hole = new Buraco();

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
        animacoes = AnimationFactory.create(animationName, 4, 32, 48, AnimationEnum.getAll());
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

        if (collisionManager.isColliding(hole.getBounding(), getPisando())){
            System.out.println("Caiu no buraco :/");
            br.com.tlr.game.states.LevelGrass.EXIT_GAME = true;
        } else if (comandos.isAtkCmd() &&  collisionManager.isColliding(shape, getBounding())){
            System.out.println("ACERTOU O ATK!!");
            // br.com.tlr.game.states.LevelGrass.EXIT_GAME = true;
        } else System.out.println("---");

//        if (comandos.isAtkCmd() &&  hole.getTst().intersects(shape)){
//            System.out.println("ACERTOU O ATK!!");
//        }  else System.out.println("");
//        if (comandos.isAtkCmd() &&  collisionManager.isColliding(getBounding(), hole.getBounding())){



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
        g.draw(hole.getShape());
        g.fill(hole.getShape());
        g.draw(getPisando());
        g.draw(getBounding());
        g.draw(shape);
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
     * Borda do mouse
     */
    private class Buraco extends StaticElement {

        private final Shape shape;

        public Buraco() {
            super(175f, 175f, 100f, 100f);
            shape = new Rectangle(getX(), getY(), getWidth(), getWidth());
        }

        public Shape getShape(){
            return shape;
        }

    }

}
