/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OLD_PACKAGES;

import br.com.tlr.encapsulation.Animacoes;
import OLD_PACKAGES.GameOverException;
import br.com.tlr.elements.Animable;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.command.InputProvider;
import org.newdawn.slick.command.InputProviderListener;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.RoundedRectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

/**
 * Classe responsável pela criação de personagens
 *
 * @author JOAO
 */
public abstract class Character extends Movable implements Animable, InputProviderListener {

    /**
     * Nome da animaçao
     */
    protected final String animationName;
    /**
     * Quadro máximo que os players podem se mover
     */
    protected final float[][] movableArea;
    /**
     * Número de quadros por animação do personagem
     */
    protected final int numFrames;

    // Array de animações (Reestruturar para ser possível de tornar FINAL)
    protected Animacoes animacoes;
    /**
     * The input provider abstracting input
     */
    protected InputProvider provider;
    protected final LifeManager lifeManager = new LifeManager();
    /**
     * Objeto responsável pelo gerenciamento de comandos
     */
    protected Comandos comandos = new Comandos();
    protected Shape shape = new Circle(0f, 0f, 25f);
    protected Vector2f mPos = new Vector2f();

    /**
     * Construtor padrão de um Character
     *
     * @param animationName Nome do arquivo de animações do personagem
     * @param numFrames Número de frames por sprite
     * @param movableArea Dimensões máximas do jogador
     */
    public Character(String animationName, int numFrames, float[][] movableArea, CollisionManager collisionManager) {
        super(32f, 48f, collisionManager);
        this.animationName = animationName;
        this.numFrames = numFrames;
        this.movableArea = movableArea;
    }

    /**
     * Carrega as imagens e as animações
     *
     * @param container Container do jogo
     * @throws SlickException Problema no carregamento dos objetos na API
     */
    @Override
    public void load(GameContainer container) throws SlickException {
        // Instancia InputProvider do Player
        provider = new InputProvider(container.getInput());
        lifeManager.load(container);
        provider.addListener(this);
        // Amarra comandos no gerenciador InputProvider
        comandos.bindComandos(provider);
        lifeManager.load(container);
    }

    /**
     * Atualiza os frames do jogo
     *
     * @param gc Container do jogo
     * @param delta Tempo de atualização
     * @throws SlickException Problema ao atualizar quadros
     * @throws OLD_PACKAGES.GameOverException
     */
    @Override
    public void update(GameContainer gc, int delta) throws SlickException, GameOverException {
        // Entradas do jogo
        Input input = gc.getInput();
        mPos.x = input.getAbsoluteMouseX();
        mPos.y = input.getAbsoluteMouseY();
        
    }

    public boolean isBeingHurt() {
        return lifeManager.isBeingHurt();
    }

    /**
     * Retorna um retângulo arredondado do tamanho do objeto (para checar
     * colisões)
     *
     * @return Shape
     */
    public Shape getPisando() {
        return new RoundedRectangle(getX() + 8, getY() + 40, getWidth() - 14, getHeight() / 6, 30f);
    }

    public void hurt(SpacialElement cause) throws GameOverException {
        hurt("Tomou dano de: " + cause.toString());
    }

    public void hurt(String msg) throws GameOverException {
        hurt(1, msg);
    }

    public void hurt(int damage, String msg) throws GameOverException {
        if (isBeingHurt()) return;
        lifeManager.subHearts(damage, msg);
        setX(15f);
        setY(15f);
        animacoes.setColor(Color.yellow);
    }
    
    @Override
    public String toString(){
        return "Character";
    }

}
