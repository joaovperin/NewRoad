/*
 * TestLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.manager;

import org.newdawn.slick.geom.Shape;

/**
 * Objeto responsável pelo controle de colisões
 */
public class CollisionManager {

    /**
     * Retorna verdadeiro se os formatos colidem
     *
     * @param a
     * @param b
     * @return boolean
     */
    public boolean isColliding(Shape a, Shape b) {
        return a.intersects(b) || a.contains(b) || b.contains(a) || b.intersects(a);
    }

}
