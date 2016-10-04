/*
 * TheLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.elements;

/**
 * Classe abstrata a ser extendida por todos os ataques do jogo
 */
public abstract class Attack extends Movable implements Animable {

    public Attack(int height, int width) {
        super(height, width);
    }

}
