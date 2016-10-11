/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OLD_PACKAGES;

import static br.com.tlr.factory.AnimationFactory.SPRITES_DIR;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author 0199831
 */
public class Shot extends Attack {

    /** Nome da animaçao */
    private final String animationName;
    /** Tempo de vida do tiro */
    private final int lifeSpan;
    /** Tiro */
    private Animation tiro;

    /** Contador de tempo do tiro */
    private int counter;
    /** Se está vivo o bagulho */
    private boolean isAlive;
    /** Direção de movimentação */
    private int dir;

    /**
     * Construtor da classe que recebe o lifespan
     *
     * @param animationName
     * @param lifeSpan
     */
    public Shot(String animationName, int lifeSpan) {
        super(32, 24);
        this.animationName = animationName;
        this.lifeSpan = lifeSpan;
        this.isAlive = false;
        this.counter = 0;
    }

    /**
     * Carrega as imagens e as animações
     *
     * @param container Container do jogo
     * @throws SlickException Problema no carregamento dos objetos na API
     */
    @Override
    public void load(GameContainer container) throws SlickException {
        // Carrega sprites para as animações de movimentos
        SpriteSheet sheet = new SpriteSheet(SPRITES_DIR + animationName, 32, 24);
        // Carrega frames de animação do character da spritesheet
        tiro = new Animation(sheet, 0, 0, 6, 0, true, 100, true);
    }

    /**
     * Atualiza os frames do jogo
     *
     * @param container Container do jogo
     * @param delta Tempo de atualização
     * @throws SlickException Problema ao atualizar quadros
     */
    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        int fps = container.getFPS();
        if (isAlive) {
            // Verifica se deve encerrar
            if (counterInc(fps) >= lifeSpan) {
                die();
            }
            // Move
            switch (dir) {
                case 0:
                    subY(movInc(fps));
                    break;
                case 1:
                    addY(movInc(fps));
                    break;
                case 2:
                    subX(movInc(fps));
                    break;
                case 3:
                    addX(movInc(fps));
                    break;
            }
        }
    }

    /**
     * Renderiza as imagens do jogo
     *
     * @param container Container do jogo
     * @param g Contexto gráfico usado para renderizar o canvas
     * @throws SlickException Problema na renderização de imagens na API
     */
    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        if (isAlive) {
            tiro.draw(getX(), getY());
        }
    }

    /**
     * Ação de tiro -> A IMPLEMENTAR
     *
     * @param delta
     */
    public void shoot(int delta, float x, float y, int dir) {
        System.out.println("Tiro");
        isAlive = true;
        setX(x);
        setY(y);
        this.dir = dir;
        counter = 0;
    }

    private int counterInc(int fps) {
        counter += (int) 100 / (fps + 1);
        return counter;
    }

    private float movInc(int fps) {
        return 0.1f * 1000 / (fps + 1);
    }

    private void die() {
        counter = 0;
        isAlive = false;
    }

}
