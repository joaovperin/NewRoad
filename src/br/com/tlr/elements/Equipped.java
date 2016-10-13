/*
 * NewRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.elements;

import br.com.tlr.interfaces.Renderable;
import java.util.List;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 * Itens equipados no jogador
 */
public class Equipped implements Renderable {

    /** Lista de itens equipados */
    List<Item> itens;

    @Override
    public void load(GameContainer container) throws SlickException {
        for (Item item : itens) {
            item.load(container);
        }
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        for (Item item : itens) {
            item.update(container, delta);
        }
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        for (Item item : itens) {
            item.render(container, g);
        }
    }

}
