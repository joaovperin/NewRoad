/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tlr.elements;

import OLD_PACKAGES.GameOverException;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author 0199831
 */
public abstract class Element {
    /**
     * Carrega as imagens e as animações
     *
     * @param container Container do jogo
     * @throws SlickException Problema no carregamento dos objetos na API
     */
    public abstract void load(GameContainer container) throws SlickException;

    /**
     * Atualiza os frames do jogo
     *
     * @param container Container do jogo
     * @param delta Tempo de atualização
     * @throws SlickException Problema ao atualizar quadros
     * @throws OLD_PACKAGES.GameOverException
     */
    public abstract void update(GameContainer container, int delta) throws SlickException, GameOverException;

    /**
     * Renderiza as imagens do jogo
     *
     * @param container Container do jogo
     * @param g Contexto gráfico usado para renderizar o canvas
     * @throws SlickException Problema na renderização de imagens na API
     */
    public abstract void render(GameContainer container, Graphics g) throws SlickException;
}
