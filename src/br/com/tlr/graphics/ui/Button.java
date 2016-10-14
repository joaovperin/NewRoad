/*
 * NewRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.graphics.ui;

import br.com.tlr.interfaces.Renderable;
import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;

/**
 * Descrição da classe.
 */
public class Button implements Renderable {

    private int id = 0;
    String desc = "botao teste";
//    float x, y, cX, cY;
//    float length, width;
    float mRadius = 2.5f;

    Shape shape;
    Color shapeColor;
    Color fontColor = Color.black;
    Font font;
    private Circle cursor;

    @Override
    public void load(GameContainer gc) throws SlickException {
        cursor = new Circle(5f, 25f, mRadius);
        shape = new Ellipse((gc.getWidth() / 2), gc.getHeight() / 15 + 50, 300f, 50f);
        font = new AngelCodeFont("org/newdawn/slick/data/defaultfont.fnt", "org/newdawn/slick/data/defaultfont.png");
        shapeColor = Color.green;
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        Input input = gc.getInput();
        // Seta o cursor na posição do mouse
        cursor.setCenterX(input.getAbsoluteMouseX());
        cursor.setCenterY(input.getAbsoluteMouseY());
        // Se o cursor do mouse estiver dentro ou interseccionando o botão play
        shapeColor = shape.contains(cursor) || cursor.intersects(shape) ? Color.red : Color.green;
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        g.setColor(shapeColor);
        g.fill(shape);
        g.setColor(fontColor);
        g.drawString(desc, (shape.getCenterX() - font.getWidth(desc) / 2), shape.getCenterY() - font.
                        getHeight(desc) / 2);
        g.draw(cursor);
    }

}
