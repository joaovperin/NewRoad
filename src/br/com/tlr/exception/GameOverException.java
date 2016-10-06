/*
 * TestLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.exception;

/**
 * Descrição da classe.
 */
public class GameOverException extends Throwable {

    public GameOverException() {
        super();
    }

    public GameOverException(Throwable e) {
        super(e);
    }

    public GameOverException(String msg) {
        super(msg);
    }

}
