/*
 * NewRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.elements;

import br.com.tlr.interfaces.Renderable;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Descrição da classe.
 */
public abstract class Item implements Renderable {

    /** Id do item */
    private final int id;
    /** Tipo do item */
    private final int type;
    /** Descrição do item */
    private final String nome;
    /** Se deve mostrar o item */
    private boolean show;

    public Item(int id, int type, String nome) {
        this.id = id;
        this.type = type;
        this.nome = nome;
    }

    @Override
    public void load(GameContainer container) throws SlickException {

    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        if (show){
            getItemById(id).draw();
        }
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    private Animation getItemById(int id){
        return new Animation();
    }

}
