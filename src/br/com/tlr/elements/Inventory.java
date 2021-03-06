/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tlr.elements;

import br.com.tlr.interfaces.Renderable;
import java.util.List;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author 0199831
 */
public class Inventory implements Renderable {

    /** Lista de itens do inventário */
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
