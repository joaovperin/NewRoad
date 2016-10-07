/*
 * TestLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.exception;

/**
 * Exception a ser utilizada para finalizar o jogo
 */
public class GameOverException extends Throwable {

    /**
     * Construtor padrão da exception
     *
     * @param causa Exception que gerou o problema
     */
    public GameOverException(Throwable causa) {
        super(causa);
    }

    /**
     * Construtor padrão da exception
     *
     * @param mensagem Mensagem do problema
     */
    public GameOverException(String mensagem) {
        super(mensagem);
    }

    /**
     * Construtor padrão da exception
     *
     * @param mensagem Mensagem do problema
     * @param causa Exception que gerou o problema
     */
    public GameOverException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}
