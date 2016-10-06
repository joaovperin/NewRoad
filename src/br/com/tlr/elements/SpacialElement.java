/*
 * TestLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.elements;

import org.newdawn.slick.geom.RoundedRectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

/**
 * Classe abstrata para representar elementos que ocupam espaço
 */
public abstract class SpacialElement {

    /** Posição atual do objeto */
    protected Vector2f pos = new Vector2f();
    /** Altura */
    protected final int height;
    /** Largura */
    protected final int width;

    /**
     * Construtor padrão que recebe a altura e largura do objeto para inicializar
     *
     * @param width
     * @param height
     */
    public SpacialElement(int width, int height) {
        this.width = width;
        this.height = height;
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

    /**
     * Retorna um retângulo arredondado do tamanho do objeto (para checar colisões)
     *
     * @return Shape
     */
    protected Shape getBounding(){
        return new RoundedRectangle(getX(), getY(), getWidth(), getHeight(), 30f);
    }

}
