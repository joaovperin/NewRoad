/*
 * NewRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.elements;

import br.com.tlr.interfaces.Renderable;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 * Descrição da classe.
 */
public abstract class Item  implements Renderable {

    /** Id do item */
    private int id;
    /** Tipo do item */
    private int type;
    /** Descrição do item */
    private String nome;

    @Override
    public void load(GameContainer container) throws SlickException {

    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}
