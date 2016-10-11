/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OLD_PACKAGES;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author 0199831
 */
class lol extends BasicGameState {

    /** Mouse cursor */
    private Circle cursor;
    private Image background;
    Shape shape;

    /**
     * Retorna o ID do estado
     *
     * @return int
     */
    @Override
    public int getID() {
        return 0;
    }

    /**
     * Carrega as imagens e as animações
     *
     * @param container Container do jogo
     * @param game
     * @throws SlickException Problema no carregamento dos objetos na API
     */
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        cursor = new Circle(5f, 25f, 25f);
        background = new Image("data/menu/bg-squares-3d.jpg");
        shape = new Ellipse((gc.getWidth()/2), gc.getHeight()/15 + 50, 300f, 50f);
    }

    /**
     * Atualiza os frames do jogo
     *
     * @param container Container do jogo
     * @param game
     * @param delta Tempo de atualização
     * @throws SlickException Problema ao atualizar quadros
     */
    @Override
    public void update(GameContainer container, StateBasedGame sbg, int i) throws SlickException {
        Input input = container.getInput();
        if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            cursor.setRadius(5f);
        } else if (input.isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON)) {
            cursor.setRadius(55f);
        } else {
            cursor.setRadius(25f);
        }
        cursor.setCenterX(input.getAbsoluteMouseX());
        cursor.setCenterY(input.getAbsoluteMouseY());

        if (cursor.intersects(shape)){
            shape.setX(shape.getX() - 5f);
        } else {
            if (shape.getX() < 500f){
                shape.setX(shape.getX() + 5f);
                nextState(sbg);
            }
        }
//        } else shape.union(cursor);
    }

    private void nextState(StateBasedGame sbg){
        sbg.enterState(sbg.getCurrentStateID() + 1);
    }

    /**
     * Renderiza as imagens do jogo
     *
     * @param container Container do jogo
     * @param game
     * @param g Contexto gráfico usado para renderizar o canvas
     * @throws SlickException Problema na renderização de imagens na API
     */
    @Override
    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
        Input input = container.getInput();
        Color colorBefore = g.getColor();
        background.draw();
        g.setColor(Color.yellow);

        g.drawString("teste hahaha hehe", shape.getCenterX(), shape.getCenterY());
//        g.fillOval();
                g.fill(shape);
                g.draw(shape);
        g.setColor(colorBefore);
        g.fill(cursor);
        g.draw(cursor);
    }

}
