/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tlr.encapsulation;

import br.com.tlr.elements.Animable;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Vector2f;

/**
 * Objeto que encapsula uma animação do Slick2D
 *
 * @author 0199831
 */
public class Animacao implements Animable {

    /** Código da animação */
    private final int code;
    /** Nome da animação */
    private final String name;
    /** Folha de sprites da animação */
    private final SpriteSheet sheet;
    /** Último quadrado no eixo X */
    private final int lastX;
    /** Interface com método de movimentação */
    public Move move;
    private Color color = Color.gray;

    /** Animação do Slick2D */
    private Animation animation;
    private Vector2f pos;

    /** Tempo total da animação */
    private static final int TEMPO_ANIMACAO = 800;

    /**
     * Construtor padrão das animações
     *
     * @param animationEnum Elemento enumerado com dados da animação
     * @param numFrames Número de frames da animação
     * @param sheet Folha de sprites da animação
     */
    public Animacao(AnimationEnum animationEnum, int numFrames, SpriteSheet sheet) {
        this.move = animationEnum.getMove();
        this.code = animationEnum.getOrder();
        this.name = animationEnum.getName();
        this.lastX = numFrames - 1;
        this.sheet = sheet;
        this.pos = new Vector2f();
    }

    /**
     * Carrega as imagens e as animações
     *
     * @param container Container do jogo
     * @throws SlickException Problema no carregamento dos objetos na API
     */
    @Override
    public void load(GameContainer container) throws SlickException {
        this.animation = new Animation(sheet, 0, code, lastX, code, true, createDuration(), true);
    }

    /**
     * Cria duração das animações baseado no número de frames
     *
     * @return int
     */
    private int createDuration() {
        return TEMPO_ANIMACAO / (lastX + 1);
    }

    /**
     * Retorna o código da animação
     *
     * @return int
     */
    public int getCode() {
        return code;
    }

    /**
     * Retorna o nome da animação
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    public void changePosition(Vector2f pos){
        move.changePosition(pos);
    }

    /**
     * Move a animação para as coordenadas indicadas
     *
     * @param x
     * @param y
     */
    public void move(float x, float y) {
        this.pos.x = x;
        this.pos.y = y;
    }

    /**
     * Move a animação para a posição indicada
     *
     * @param pos
     */
    public void move (Vector2f pos){
        this.pos = pos;
    }

    /**
     * Retorna a animação do Slick2D
     *
     * @return Animation
     */
    public Animation getAnimation() {
        return animation;
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        animation.update(delta);
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        animation.draw(pos.getX(), pos.getY(), color);
    }
    
    public void setColor (Color color){
        this.color = color;
    }

}
