/*
 * TestLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.manager;

import br.com.tlr.elements.Heart;
import br.com.tlr.exception.GameOverException;
import java.util.ArrayList;
import java.util.List;

/**
 * Descrição da classe.
 */
public class LifeManager {

    private int numHearts;
    private List<Heart> hearts = new ArrayList<>();

    public LifeManager() {
        numHearts = 10;
    }

    public LifeManager(int numHearts) {
        this.numHearts = numHearts;
    }

    public void subHeart() throws GameOverException {
        subHearts(1);
    }

    public void subHearts(int numHearts) throws GameOverException {
        this.numHearts -= numHearts;
        if (numHearts <= 0) {
            throw new GameOverException("Você morreu :D");
        }
    }

    public int getNumHearts() {
        return numHearts;
    }

    public void render(){

    }

}
