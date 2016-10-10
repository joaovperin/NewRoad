/*
 * TestLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.elements;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

/**
 * Descrição da classe.
 */
public class Obstaculo extends StaticElement {

    private final Shape shape;

    public Obstaculo() {
        super(175f, 175f, 100f, 100f);
        shape = new Rectangle(getX(), getY(), getWidth(), getWidth());
    }

    public Shape getShape() {
        return shape;
    }

}
