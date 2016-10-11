/*
 * TestLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package OLD_PACKAGES;

/**
 * Exception a ser utilizada para detectar colisões
 */
public class CollisionException extends Throwable {

    /**
     * Objeto que colidiu
     */
    private final SpacialElement whoCollided;

    /**
     * Construtor padrão da exception
     *
     * @param whoCollided Objeto que causou a colisão
     */
    public CollisionException(SpacialElement whoCollided) {
        this("Colisão!", whoCollided);
    }

    /**
     * Construtor padrão da exception
     *
     * @param mensagem Mensagem do problema
     * @param whoCollided Objeto que causou a colisão
     */
    public CollisionException(String mensagem, SpacialElement whoCollided) {
        super(mensagem);
        this.whoCollided = whoCollided;
    }

    public SpacialElement getObject() {
        return whoCollided;
    }

}
