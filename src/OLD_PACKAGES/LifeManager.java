/*
 * TestLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package OLD_PACKAGES;

import br.com.tlr.elements.Animable;
import OLD_PACKAGES.Heart;
import OLD_PACKAGES.GameOverException;
import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 * Classe responsável pelo controle de vida dos characters
 */
public class LifeManager implements Animable {

    // IMPLEMENTAR CONTROLE DE POSIÇÃO PARA DESENHAR OS HEARTS
    private int numHearts;
    private final List<Heart> hearts = new ArrayList<>();
    /** UTILIZAR ISSO PRA CONTROLE DE INVENCIBLE TIME AFTER HIT */
    private final TimeManager timeManager = new TimeManager();

    public LifeManager() {
        this(10);
    }

    public LifeManager(int numHearts) {
        this.numHearts = numHearts;
        // Inicializa Hearts
        int conMax = 0;
        for (int x = 0; x < numHearts; x++) {
            float calcX = 800 - 25*x - x*3;
            hearts.add(new Heart(50, 50, calcX, 0));
        }
        timeManager.start(3000);
    }

    public void subHeart(String msg) throws GameOverException {
        subHearts(1, msg);
    }

    /**
     * Subtrai um determinado número de corações
     *
     * @param dmg
     * @param msg
     * @throws GameOverException
     */
    public void subHearts(int dmg, String msg) throws GameOverException {
        // Se já perdeu vida
        if (timeManager.isRunning()) {
            return;
        }
        System.out.println(msg);
        new Thread(timeManager).start();
        this.numHearts -= dmg;
        hearts.remove(numHearts);
        if (numHearts == 1) {
            throw new GameOverException("Você morreu :D");
        }
    }

    /**
     * Retorna o número de hearts
     *
     * @return int
     */
    public int getNumHearts() {
        return numHearts;
    }
    
    public boolean isBeingHurt(){
        return timeManager.isRunning();
    }

    /**
     * Carrega os hearts
     *
     * @param container
     * @throws SlickException
     */
    @Override
    public void load(GameContainer container) throws SlickException {
        for (Heart heart : hearts) {
            heart.load(container);
        }
    }

    /**
     * Atualiza os hearts
     *
     * @param container
     * @param delta
     * @throws SlickException
     */
    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        for (Heart heart : hearts) {
            heart.update(container, delta);
        }
    }

    /**
     * Renderiza os hearts
     *
     * @param container
     * @param g
     * @throws SlickException
     */
    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        for (Heart heart : hearts) {
            heart.render(container, g);
        }
    }

}
