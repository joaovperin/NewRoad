/*
 * TestLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.game.states.transitions;

import org.newdawn.slick.Color;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.state.transition.Transition;

/**
 * Descrição da classe.
 */
public enum TransitionsEnum {

    CLOSE_MENU(new FadeOutTransition(), Color.red), GAME_START(new FadeInTransition(), Color.yellow);

    private Transition tr;
    private Color color;

    private TransitionsEnum(Transition tr) {
        this(tr, Color.red);
    }

    private TransitionsEnum(Transition tr, Color color) {
        this.tr = tr;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
