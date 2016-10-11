/*
 * TestLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package OLD_PACKAGES;

import org.newdawn.slick.geom.Vector2f;

/**
 * * Classe abstrata para todos os itens que podem se mover
 *
 * @author 0199831
 */
public abstract class StaticElement extends SpacialElement {

    /**
     * Construtor padrão que recebe a altura e largura do objeto para
     * inicializar
     *
     * @param width
     * @param height
     */
    public StaticElement(float width, float height, CollisionManager collisionManager) {
        this(0, 0, width, height, collisionManager);
    }

    /**
     * Construtor que recebe as coordenadas X e Y do objeto
     *
     * @param width
     * @param height
     * @param x
     * @param y
     */
    public StaticElement(float x, float y, float width, float height, CollisionManager collisionManager) {
        this(x, y, width, height, collisionManager, false);
    }

    /**
     * Construtor que recebe as coordenadas X e Y do objeto
     *
     * @param width
     * @param height
     * @param x
     * @param y
     */
    public StaticElement(float x, float y, float width, float height, 
            CollisionManager collisionManager, boolean justCheckFoot) {
        super(width, height, collisionManager, justCheckFoot);
        pos.x = x;
        pos.y = y;
    }

    /**
     * Construtor que recebe as um vector2f com as coordenadas do objeto
     *
     * @param width
     * @param height
     * @param pos
     */
    public StaticElement(float width, float height, Vector2f pos, 
            CollisionManager collisionManager) {
        this(width, width, width, height, collisionManager, false);
    }

    /**
     * Construtor que recebe as um vector2f com as coordenadas do objeto
     *
     * @param width
     * @param height
     * @param pos
     */
    public StaticElement(float width, float height, Vector2f pos, 
            CollisionManager collisionManager, boolean justCheckFoot) {
        super(width, height, collisionManager, justCheckFoot);
        this.pos = pos;
    }

}
