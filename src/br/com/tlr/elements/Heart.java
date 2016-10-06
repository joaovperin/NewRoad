/*
 * TestLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.elements;

import static br.com.tlr.factory.AnimationFactory.SPRITES_DIR;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 * Descrição da classe.
 */
public class Heart extends Movable implements Animable {

    /** Heart */
    private Animation heart;
    /** Nome da animaçao */
    private final String animationName;
    /** Direção de movimentação */
    private boolean isAlive;

    public Heart() {
        super(32, 24);
        animationName = "";
    }

    public boolean isIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    @Override
    public void load(GameContainer container) throws SlickException {
        // Carrega sprites para as animações de movimentos
        SpriteSheet sheet = new SpriteSheet(SPRITES_DIR + animationName, 32, 24);
        // Carrega frames de animação do character da spritesheet
        heart = new Animation(sheet, 0, 0, 3, 0, true, 100, true);
        isAlive = true;
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {

    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        if (isAlive) {
            heart.draw(getX(), getY());
        }
    }

}
