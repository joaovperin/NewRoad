/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tlr.encapsulation;

import br.com.tlr.elements.Animable;
import java.util.List;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/**
 * Classe responsável por encapsular um conjunto de animações
 *
 * @author 0199831
 */
public class Animacoes implements Animable {

    /** Animação atual */
    private int current;
    /** Array de animações */
    private final List<Animacao> animacoes;
    /** Indica se está se movendo */
    private boolean running;
    private final int width;
    private final int height;

    /**
     * Construtor que recebe uma lista de animações
     *
     * @param animacoes
     * @param width
     * @param height
     */
    public Animacoes(List<Animacao> animacoes, int width, int height) {
        this.width = width;
        this.height = height;
        this.animacoes = animacoes;
    }

    /**
     * Inicializa animação
     *
     * @param direction
     */
    public void init(AnimationEnum direction) {
        setCurrent(AnimationEnum.LEFT);
        stop();
    }

    /**
     * Define a animação corrente
     *
     * @param direction
     */
    public void setCurrent(AnimationEnum direction) {
        this.current = direction.getOrder();
        start();
    }

    /**
     * Troca a posição da animação
     *
     * @param pos
     */
    public void changePosition(Vector2f pos) {
        if (running) {
            getCurrent().changePosition(pos);
        }
    }

    /**
     * Carrega as imagens e as animações
     *
     * @param container Container do jogo
     * @throws SlickException Problema no carregamento dos objetos na API
     */
    @Override
    public void load(GameContainer container) throws SlickException {
        for (Animacao a : animacoes) {
            a.load(container);
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
        getCurrent().update(container, delta);
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
        getCurrent().render(container, g);
    }
    
    public void setColor (Color color){
        getCurrent().setColor(color);
    }

    /**
     * Move a animação
     *
     * @param x
     * @param y
     */
    public void move(float x, float y) {
        getCurrent().move(x, y);
    }

    /**
     * Move a animação
     *
     * @param pos
     */
    public void move(Vector2f pos) {
        getCurrent().move(pos);
    }

    /**
     * Inicia movimentos da animação
     */
    public void start() {
        getCurrent().getAnimation().setAutoUpdate(true);
        running = true;
    }

    /**
     * Pausa movimentação da animação
     */
    public void stop() {
        running = false;
        getCurrent().getAnimation().setAutoUpdate(false);
//        getCurrent().getAnimation().restart();
    }

    /**
     * Retorna a animação atual
     *
     * @return Animacao
     */
    private Animacao getCurrent() {
        return animacoes.get(current);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

}
