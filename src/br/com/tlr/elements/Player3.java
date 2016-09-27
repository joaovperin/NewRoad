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
    /** The message to be displayed */
    private final String controlMessage = "HIT";
    boolean atk = false;

    Shape shape = new Circle(0f, 0f, 25f);
    Vector2f mPos = new Vector2f();

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
        // Direções
        comandos.bindComandos(provider);

        // Cria e carrega as animações
        animacoes = AnimationFactory.create(animationName, 4, AnimationEnum.getAll());
        animacoes.load(container);
        // Inicializa o character movendo virado para a esquerda
        animacoes.setCurrent(AnimationEnum.LEFT);

        animacoes.stop();
    }

    /**
     * Atualiza os frames do jogo
     *
     * @param container Container do jogo
     * @param delta Tempo de atualização
     * @throws SlickException Problema ao atualizar quadros
     */
    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        animacoes.stop();
        // Entradas do jogo
        Input input = container.getInput();

        mPos.x = input.getAbsoluteMouseX();
        mPos.y = input.getAbsoluteMouseY();

//        System.out.println("Key: " + AnimationEnum.getByName(Keyboard.getKeyName(Keyboard.getEventKey())).test()); // USAR ISSO PRA DETECTAR O MOVIMENTO
//        AnimationEnum.getByName(Keyboard.getKeyName(Keyboard.getEventKey())).test();
        // Ações de movimentação - DOWN
        if (comandos.isDownCmd()) {
            if (getY() >= movableArea[1][1]) {
                return;
            }
            animacoes.setCurrent(AnimationEnum.DOWN);
            addY(delta * 0.1f);
        }
        // Ações de movimentação - LEFT
        if (comandos.isLeftCmd()) {
            if (getX() <= movableArea[0][0]) {
                return;
            }
            animacoes.setCurrent(AnimationEnum.LEFT);
            subX(delta * 0.1f);
        }
        // Ações de movimentação - RIGHT
        if (comandos.isRightCmd()) {
            if (getX() >= movableArea[0][1]) {
                return;
            }
            animacoes.setCurrent(AnimationEnum.RIGHT);
            addX(delta * 0.1f);
        }
        // Ações de movimentação - UP
        if (comandos.isUpCmd()) {
            if (getY() <= movableArea[1][0]) {
                return;
            }
            animacoes.setCurrent(AnimationEnum.UP);
            subY(delta * 0.1f);
        }
//        animacoes.changePosition(pos);
    }

    /**
     * Renderiza as imagens do jogo
     *
     * @param container Container do jogo
     * @param g Contexto gráfico usado para renderizar o canvas
     * @throws SlickException Problema na renderização de imagens na API
     */
    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        if (atk) {
            g.drawString(controlMessage, mPos.x, mPos.y);
//            shape.setLocation(mPos);
            shape.setCenterX(mPos.x);
            shape.setCenterY(mPos.y);
            g.fill(shape);
        }
        animacoes.move(pos);
        animacoes.render(container, g);
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

}
