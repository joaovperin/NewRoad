/*
 * TestLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.elements;

import org.newdawn.slick.geom.Vector2f;

/**
 * Classe abstrata para representar elementos que ocupam espaço
 */
public abstract class SpacialElement {

    /** Posição atual do objeto */
    protected Vector2f pos = new Vector2f();
    protected int height;
    protected int width;

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
     * Retorna a posição atual
     *
     * @return Vector2f
     */
    protected Vector2f getPos() {
        return pos;
    }

    /**
     * Retorna a largura do objeto
     *
     * @return int
     */
    protected int getWidth() {
        return width;
    }

    /**
     * Retorna a altura do objeto
     *
     * @return int
     */
    protected int getHeight() {
        return height;
    }

    protected void setWidth(int width){
        this.width = width;
    }
    protected void setHeight(int height){
        this.height = height;
    }


}
