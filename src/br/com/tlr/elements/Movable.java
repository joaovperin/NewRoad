/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tlr.elements;

/**
 * * Classe abstrata para todos os itens que podem se mover
 *
 * @author 0199831
 */
public abstract class Movable extends SpacialElement {

    /**
     * Construtor padrão que recebe a altura e largura do objeto para inicializar
     *
     * @param width
     * @param height
     */
    public Movable(int width, int height) {
        super(width, height);
    }

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
