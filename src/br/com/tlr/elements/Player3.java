/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tlr.elements;

import br.com.tlr.encapsulation.AnimationEnum;
import br.com.tlr.exception.GameOverException;
import br.com.tlr.factory.AnimationFactory;
import br.com.tlr.manager.CollisionManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.command.Command;

/**
 *
 * @author JOAO
 */
public class Player3 extends Character {

    private final CollisionManager collisionManager = new CollisionManager();

    // LER ISSO!
    //http://zetcode.com/tutorials/javagamestutorial/collision/
    // https://github.com/dmitrykolesnikovich/featurea/tree/master/engines/platformer
    // https://gamedevelopment.tutsplus.com/tutorials/collision-detection-using-the-separating-axis-theorem--gamedev-169   SAT
//        http://blog.sklambert.com/html5-canvas-game-2d-collision-detection/
    Obstaculo hole = new Obstaculo();
    //private final List<SpacialElement> spacialElements = new ArrayList<>();
    //spacialElements.add(new Obstaculo());

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
        super.load(container);
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
     * @throws br.com.tlr.exception.GameOverException
     */
    @Override
    public void update(GameContainer gc, int delta) throws SlickException, GameOverException {
        // Checa se recebeu ataques
        if (collisionManager.isColliding(hole.getBounding(), getPisando())) {
            hurt("Caiu no buraco :/");
        } else if (comandos.isAtkCmd() && collisionManager.isColliding(shape, getBounding())) {
            hurt("ACERTOU O ATK!!");
        }
        animacoes.stop();
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
        lifeManager.update(gc, delta);
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
        lifeManager.render(gc, g);
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
