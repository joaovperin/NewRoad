/*
 * NewRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.graphics.ui;

import br.com.tlr.custom.Cor;
import br.com.tlr.database.GameStates;
import br.com.tlr.game.core.Resources;
import br.com.tlr.game.core.TheNewRoad;
import br.com.tlr.interfaces.Renderable;
import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Descrição da classe.
 */
public class Button implements Renderable {

    /** Número de botões instanciados */
    private static int NUM_BUTTONS = 0;
    /** Raio do mouse para considerar */
    private static final float MOUSE_RADIUS = 2.5f;
    /** Cores Default */
    private static final Color DEF_SHAPE_COLOR = Color.blue;
    private static final Color DEF_FONT_COLOR = Color.black;

    /** Identificador único do botão */
    private final int id;
    /** Descrição do botão */
    private final String desc;
    /** Cor original da forma */
    private final Color shapeColor;
    /** Coordenadas centrais, altura e largura */
    private final float cX, cY, height, width;
    /** Está clicando em cima? Botão esquerdo */
    private boolean isClickingLeft;
    /** Está clicando em cima? Botão direito */
    private boolean isClickingRight;

    private Color currentColor;

    private Shape shape;
    private Font font;
    private Color fontColor;
    private Circle cursor;
    private Image btImg;

    public Button(String desc, float cX, float cY, float width, float height) {
        this(desc, cX, cY, width, height, DEF_SHAPE_COLOR, DEF_FONT_COLOR);
    }

    public Button(String desc, float cX, float cY, float width, float height, Color shapeColor, Color fontColor) {
        this.desc = desc;
        this.cX = cX;
        this.cY = cY;
        this.width = width;
        this.height = height;
        this.shapeColor = shapeColor;
        this.fontColor = fontColor;
        this.id = NUM_BUTTONS++;
    }

    @Override
    public void load(GameContainer gc) throws SlickException {
        shape = new Ellipse(cX, cY, width, height);
        // TODO(Perin): Tornar Singleton (Compartilhar instância por todo o Game):
        font = new AngelCodeFont("org/newdawn/slick/data/defaultfont.fnt", "org/newdawn/slick/data/defaultfont.png");
        cursor = new Circle(gc.getInput().getAbsoluteMouseX(), gc.getInput().getAbsoluteMouseY(), MOUSE_RADIUS);
        currentColor = shapeColor;
//        btImg = new Image("data/menu/bt1.png");
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
        Input input = gc.getInput();
        // Seta o cursor na posição do mouse
        cursor.setCenterX(input.getAbsoluteMouseX());
        cursor.setCenterY(input.getAbsoluteMouseY());
        // Se o cursor do mouse estiver dentro ou interseccionando o botão play
        if (shape.contains(cursor) || cursor.intersects(shape)) {
            currentColor = shapeColor.scaleCopy(0.8f);
            isClickingLeft = input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON);
            isClickingRight = input.isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON) && !isClickingLeft;
//            shapeColor = isClickingLeft ? Color.green : (isClickingRight ? getColor("FF00FF") : Color.cyan);
        } else {
            currentColor = shapeColor;
        }

        /** BTIMG -> remover */
//        int x = 0;
//        int y = 0;
//
//        String msg = "  --- ";
//        if(input.getMouseX() > x && input.getAbsoluteMouseY() > y && input.getMouseX() < x + btImg.getWidth()
//            && input.getMouseY() < y + btImg.getHeight()){
//            msg = "em cima do bt";
//        }
//        System.out.println(msg);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
        g.setColor(currentColor);
        g.fill(shape);
        g.setColor(fontColor);
        g.drawString(desc, (shape.getCenterX() - font.getWidth(desc) / 2), shape.getCenterY() - font.
                getHeight(desc) / 2);
//        btImg.draw();
        // Se estiver em modo Debug
        if (TheNewRoad.isDebugMode()) {
            g.draw(cursor);
        }
    }

    public boolean isClickingLeft() {
        return isClickingLeft;
    }

}
