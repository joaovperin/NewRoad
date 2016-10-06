/*
 * TestLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.elements;

import org.newdawn.slick.geom.Vector2f;

/**
 * * Classe abstrata para todos os itens que podem se mover
 *
 * @author 0199831
 */
public abstract class StaticElement extends SpacialElement {

    /**
     * Construtor padrão que recebe a altura e largura do objeto para inicializar
     *
     * @param width
     * @param height
     */
    public StaticElement(int width, int height) {
        super(width, height);
        pos.x = 0f;
        pos.y = 0f;
    }

    /**
     * Construtor que recebe as um vector2f com as coordenadas do objeto
     *
     * @param width
     * @param height
     * @param pos
     */
    public StaticElement(int width, int height, Vector2f pos) {
        super(width, height);
        this.pos = pos;
    }

    /**
     * Construtor que recebe as coordenadas X e Y  do objeto
     *
     * @param width
     * @param height
     * @param x
     * @param y
     */
    public StaticElement(int width, int height, float x, float y) {
        super(width, height);
        pos.x = x;
        pos.y = y;
    }

}
