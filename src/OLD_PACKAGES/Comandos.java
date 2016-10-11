/*
 * TestLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package OLD_PACKAGES;

import org.newdawn.slick.Input;
import org.newdawn.slick.command.BasicCommand;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.Control;
import org.newdawn.slick.command.InputProvider;
import org.newdawn.slick.command.KeyControl;
import org.newdawn.slick.command.MouseButtonControl;

/**
 * Objeto responsável pelo gerenciamento de comandos
 */
public class Comandos {

    /** Comandos do Slick2D */
    protected final Command cUp = new BasicCommand("UP");
    protected final Command cDown = new BasicCommand("RIGHT");
    protected final Command cLeft = new BasicCommand("LEFT");
    protected final Command cRight = new BasicCommand("DOWN");
    protected final Command cAttack = new BasicCommand("ATTACK");

    /** Flags que indicam os comandos em vigor */
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;
    private boolean attack;

    /** Teclas pressionadas */
    protected final Control keyUp = new KeyControl(Input.KEY_UP);
    protected final Control keyDown = new KeyControl(Input.KEY_DOWN);
    protected final Control keyLeft = new KeyControl(Input.KEY_LEFT);
    protected final Control keyRight = new KeyControl(Input.KEY_RIGHT);
    protected final Control mouseRClick = new MouseButtonControl(0);

    /**
     * Associa os comandos a ações do jogador
     *
     * @param provider
     */
    public void bindComandos(InputProvider provider) {
        provider.bindCommand(keyUp, cUp);
        provider.bindCommand(keyDown, cDown);
        provider.bindCommand(keyLeft, cLeft);
        provider.bindCommand(keyRight, cRight);
        provider.bindCommand(mouseRClick, cAttack);
    }

    /**
     * Determina os comandos que foram pressionados
     *
     * @param cmd
     * @return boolean
     */
    public boolean setComandos(Command cmd) {
        up = (cmd == cUp) ? true : up;
        down = (cmd == cDown) ? true : down;
        left = (cmd == cLeft) ? true : left;
        right = (cmd == cRight) ? true : right;
        attack = (cmd == cAttack) ? true : attack;
        return cmd != cAttack;
    }

    /**
     * Determina os comandos que foram soltos
     *
     * @param cmd
     * @return boolean
     */
    public boolean unsetComandos(Command cmd) {
        up = (cmd == cUp) ? false : up;
        down = (cmd == cDown) ? false : down;
        left = (cmd == cLeft) ? false : left;
        right = (cmd == cRight) ? false : right;
        attack = (cmd == cAttack) ? false : attack;
        return cmd != cAttack;
    }

    private void corrigeComandos() {
        // Se pressionar ambas as direções
        if (up && down) {
            up = false;
            down = false;
        }
        // Se pressionar ambos os lados
        if (left && right) {
            left = false;
            right = false;
        }
    }

    public boolean isUpCmd() {
        return up;
    }

    public boolean isDownCmd() {
        return down;
    }

    public boolean isLeftCmd() {
        return left;
    }

    public boolean isRightCmd() {
        return right;
    }

    public boolean isAtkCmd() {
        return attack;
    }

    public boolean canMoveUp(float current, float target){
        return !(current <= target);
    }
    public boolean canMoveDown(float current, float target){
        return !(current >= target);
    }
    public boolean canMoveLeft(float current, float target){
        return ! (current <= target);
    }
    public boolean canMoveRight(float current, float target){
        return !(current >= target);
    }

}
