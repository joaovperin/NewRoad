/*
 * TestLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package OLD_PACKAGES;

import java.io.Serializable;
import org.newdawn.slick.geom.RoundedRectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

/**
 * Classe abstrata para representar elementos que ocupam espaço
 */
public abstract class SpacialElement implements Serializable {

    /** Posição atual do objeto */
    protected Vector2f pos = new Vector2f();
    /** Altura */
    protected final float height;
    /** Largura */
    protected final float width;
    /** Manager de colisões */
    protected final CollisionManager collisionManager;
    /** dsda */
    protected boolean justCheckFoot;

    /**
     * Construtor padrão que recebe a altura e largura do objeto para inicializar
     *
     * @param width
     * @param height
     * @param collisionManager
     */
    public SpacialElement(float width, float height, CollisionManager collisionManager) {
        this(width, height, collisionManager, false);
    }
    
    /**
     * Construtor padrão que recebe a altura e largura do objeto para inicializar
     *
     * @param width
     * @param height
     * @param collisionManager
     */
    public SpacialElement(float width, float height, CollisionManager collisionManager, boolean justCheckFoot) {
        this.width = width;
        this.height = height;
        this.collisionManager = collisionManager;
        this.justCheckFoot = justCheckFoot;
    }
    
    public boolean isJustCheckFoot(){
        return justCheckFoot;
    }
    
    /**
     * Retorna a posição atual no eixo X
     *
     * @return float
     */
    protected float getX() {
        return pos.getX();
    }

    /**
     * Retorna a posição atual no eixo Y
     *
     * @return float
     */
    protected float getY() {
        return pos.getY();
    }

    /**
     * Retorna a posição atual
     *
     * @return Vector2f
     */
    protected Vector2f getPos() {
        return pos;
    }

    /**
     * Retorna a largura do objeto
     *
     * @return int
     */
    protected float getWidth() {
        return width;
    }

    /**
     * Retorna a altura do objeto
     *
     * @return int
     */
    protected float getHeight() {
        return height;
    }

    /**
     * Retorna um retângulo arredondado do tamanho do objeto (para checar colisões)
     *
     * @return Shape
     */
    public Shape getBounding(){
        return new RoundedRectangle(getX(), getY(), getWidth()-2, getHeight()-1, 30f);
    }

}
