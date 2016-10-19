/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tlr.interfaces;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author 0199831
 */
public abstract class Element implements Renderable {

    protected Vector2f pos = new Vector2f();

    /**
     * Carrega as imagens e as animações
     *
     * @param container Container do jogo
     * @throws SlickException Problema no carregamento dos objetos na API
     */
    @Override
    public abstract void load(GameContainer container) throws SlickException;

    /**
     * Atualiza os frames do jogo
     *
     * @param container Container do jogo
     * @param delta     Tempo de atualização
     * @throws SlickException Problema ao atualizar quadros
     */
    @Override
    public abstract void update(GameContainer container, StateBasedGame game, int delta) throws SlickException;

    /**
     * Renderiza as imagens do jogo
     *
     * @param container Container do jogo
     * @param g         Contexto gráfico usado para renderizar o canvas
     * @throws SlickException Problema na renderização de imagens na API
     */
    @Override
    public abstract void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException;
    
    protected float getX(){
        return pos.x;
    }
    
    protected float getY(){
        return pos.y;
    }
    
    protected void setX(float x){
        pos.x = x;
    }
    
    protected void setY(float y){
        pos.y = y;
    }

}
