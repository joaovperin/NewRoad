/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tlr.elements;

import br.com.tlr.encapsulation.AnimationEnum;
import br.com.tlr.factory.AnimationFactory;
import static br.com.tlr.factory.AnimationFactory.SPRITES_DIR;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.command.Command;

/**
 * PLAYER - primeira versão estrutural
 *
 * @author JOAO
 */
public class Player extends Character {

    /** Nome da animaçao */
    private final String animationName;
    /** Número de frames por sprite */
    private final int numFrames;

    /** Duração de cada animação */
    private final int duration;
    private int dirFacing;

    /** Quadro máximo que os players podem se mover */
    private final float[][] movableArea;

    /** Animação atual do character */
    protected Animation character;

    /** Tiro disparado pelo character */
    protected Shot tiro;

    // Animações default   (SUBSTITUIR POR ARRAYLIST)
    protected Animation up;
    protected Animation down;
    protected Animation left;
    protected Animation right;

    /**
     * Construtor padrão de um Player
     *
     * @param animationName Nome do arquivo de animações do jogador
     * @param numFrames Número de frames por sprite
     * @param movableArea Dimensões máximas do jogador
     */
    public Player(String animationName, int numFrames, float[][] movableArea) {
        super(animationName, numFrames, movableArea);
        this.animationName = animationName;
        this.numFrames = numFrames;
        this.duration = 200;
        tiro = new Shot("atk.png", 300);
        this.movableArea = movableArea;
    }

    /**
     * Carrega as imagens e as animações
     *
     * @param container Container do jogo
     * @throws SlickException Problema no carregamento dos objetos na API
     */
    @Override
    public void load(GameContainer container) throws SlickException {
        try {
            // Carrega sprites para as animações de movimentos
            SpriteSheet sheet = new SpriteSheet(SPRITES_DIR + animationName, 32, 48);

            // Cria animações
            animacoes = AnimationFactory.create(animationName, 4, 32, 48, AnimationEnum.getAll());
            animacoes.load(container);

            // Carrega frames de animação do character da spritesheet
            up = new Animation(sheet, 0, 0, 3, 0, true, duration, true);
            down = new Animation(sheet, 0, 1, 3, 1, true, duration, true);
            left = new Animation(sheet, 0, 2, 3, 2, true, duration, true);
            right = new Animation(sheet, 0, 3, 3, 3, true, duration, true);
            // Carrega os ataques
            tiro.load(container);
            // Inicializa o character movendo virado para a direita
            character = right;
            character.setAutoUpdate(false);
        } catch (SlickException e) {
            System.out.println("Ex: " + e);
        }
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
        // http://slick.ninjacave.com/forum/viewtopic.php?t=619  TECLADO SLICK2D
        // Entradas do jogo
        Input input = container.getInput();
        // Para a execução da animação
        character.setAutoUpdate(false);
        // Ação TIRO
        if (input.isKeyPressed(Keyboard.KEY_SPACE)) {
            shoot(delta);
        }
        tiro.update(container, delta);
        // Ações de movimentação - UP
        if (input.isKeyDown(Keyboard.KEY_I)) {
            if (getY() <= movableArea[1][0]) {
                return;
            }
            dirFacing = 0;
            update(delta, up);
            subY(delta * 0.1f);
        }
        // Ações de movimentação - DOWN
        if (input.isKeyDown(Keyboard.KEY_K)) {
            if (getY() >= movableArea[1][1]) {
                return;
            }
            dirFacing = 1;
            update(delta, down);
            addY(delta * 0.1f);
        }
        // Ações de movimentação - LEFT
        if (input.isKeyDown(Keyboard.KEY_J)) {
            if (getX() <= movableArea[0][0]) {
                return;
            }
            dirFacing = 2;
            update(delta, left);
            subX(delta * 0.1f);
        }
        // Ações de movimentação - RIGHT
        if (input.isKeyDown(Keyboard.KEY_L)) {
            if (getX() >= movableArea[0][1]) {
                return;
            }
            dirFacing = 3;
            update(delta, right);
            addX(delta * 0.1f);
        }
        tiro.update(container, delta);
    }

    /**
     * Ação de tiro -> A IMPLEMENTAR
     *
     * @param delta
     */
    private void shoot(int delta) {
        tiro.shoot(delta, getX(), getY(), dirFacing);
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
        character.draw(getX(), getY());
        tiro.render(container, g);
    }

    /** *********************************************************************************************
     * PRIVATE METHODS! *
     * ********************************************************************************************** */
    /**
     * Atualização do character na tela
     *
     * @param delta
     * @param animation Animação atual do character
     */
    private void update(int delta, Animation animation) {
        character = animation;
        character.setAutoUpdate(true);
        character.update(delta);
    }

    /**
     * Método responsável por detectar colisões
     *
     * @param obj
     * @return
     */
    @Override
    public boolean isCollidingWith(SpacialElement obj) {
        return false;
    }

    @Override
    public void controlPressed(Command cmnd) {
        
    }

    @Override
    public void controlReleased(Command cmnd) {

    }

}
