/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tlr.interfaces;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Interface para todos os itens renderizáveis
 *
 * @author 0199831
 */
public interface Renderable {

    /**
     * Carrega as imagens e as animações
     *
     * @param gc Container do jogo
     * @throws SlickException Problema no carregamento dos objetos na API
     */
    public void load(GameContainer gc) throws SlickException;

    /**
     * Atualiza os frames do jogo
     *
     * @param gc Container do jogo
     * @param game Aplicação do game
     * @param delta Tempo de atualização
     * @throws SlickException Problema ao atualizar quadros
     */
    public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException;

    /**
     * Renderiza as imagens do jogo
     *
     * @param gc Container do jogo
     * @param game Aplicação do game
     * @param g Contexto gráfico usado para renderizar o canvas
     * @throws SlickException Problema na renderização de imagens na API
     */
    public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException;

}
