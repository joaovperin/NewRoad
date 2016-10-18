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
import org.newdawn.slick.state.StateBasedGame;

/**
 * Objeto responsável pelo controle do Level
 *
 * @author 0199831
 */
public class Level implements Renderable {

    /** Mapa do jogo */
    Mapa mapa;
    /** Jogador */
    Player player;
    /** Barras laterais */
    SideBar sidebar;

    @Override
    public void load(GameContainer container) throws SlickException {

    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {

    }

}
