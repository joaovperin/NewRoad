/*
 * TheLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package OLD_PACKAGES;

import br.com.tlr.elements.Animable;

/**
 * Classe abstrata a ser extendida por todos os ataques do jogo
 */
public abstract class Attack extends Movable implements Animable {

    public Attack(int height, int width) {
        super(height, width, null);
    }

}
