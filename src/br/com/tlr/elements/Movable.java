/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tlr.elements;

import org.newdawn.slick.geom.Vector2f;

/**
 * * Classe abstrata para todos os itens que podem se mover
 *
 * @author 0199831
 */
public abstract class Movable {

    /** Posição atual do objeto */
    protected Vector2f pos = new Vector2f();

    /**
     * Incrementa a posição no eixo X
     *
     * @param x Valor a Incrementar na posição
     */
    protected void addX(float x) {
        pos.x += x;
    }

    /**
     * Incrementa a posição no eixo X
     *
     * @param y Valor a incrementar na posição
     */
    protected void addY(float y) {
        pos.y += y;
    }

    /**
     * Decrementa a posição no eixo X
     *
     * @param x Valor a decrementar da posição
     */
    protected void subX(float x) {
        pos.x -= x;
    }

    /**
     * Decrementa a posição no eixo Y
     *
     * @param y Valor a decrementar da posição
     */
    protected void subY(float y) {
        pos.y -= y;
    }

    /**
     * Retorna a posição atual no eixo X
     *
     * @return float
     */
    protected float getX() {
        return pos.getX();
    }

    /**
     * Retorna a posição atual no eixo Y
     *
     * @return float
     */
    protected float getY() {
        return pos.getY();
    }

    /**
     * Define o valor da posição no eixo X
     *
     * @param x Valor a definir para a posição
     */
    protected void setX(float x) {
        pos.x = x;
    }

    /**
     * Define o valor da posição no eixo Y
     *
     * @param y Valor a definir para a posição
     */
    protected void setY(float y) {
        pos.y = y;
    }

}
