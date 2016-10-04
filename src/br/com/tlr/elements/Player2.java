/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tlr.elements;

import br.com.tlr.encapsulation.AnimationEnum;
import br.com.tlr.factory.AnimationFactory;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 *
 * PLAYER utilizando array de animações - SEGUNDA VERSÃO ESTRUTURAL
 *
 * @author JOAO
 */
public class Player2 extends Character {

    /**
     * Construtor padrão de um Player
     *
     * @param animationName Nome do arquivo de animações do jogador
     * @param numFrames Número de frames por sprite
     * @param movableArea Dimensões máximas do jogador
     */
    public Player2(String animationName, int numFrames, float[][] movableArea) {
        super(animationName, numFrames, movableArea);
    }

    /**
     * Carrega as imagens e as animações
     *
     * @param container Container do jogo
     * @throws SlickException Problema no carregamento dos objetos na API
     */
    @Override
    public void load(GameContainer container) throws SlickException {
        try {
            // Cria e carrega as animações
            animacoes = AnimationFactory.create(animationName, 4, 32, 48, AnimationEnum.getAll());
            animacoes.load(container);
            // Inicializa o character movendo virado para a direita
            animacoes.setCurrent(AnimationEnum.LEFT);
        } catch (SlickException e) {
            System.out.println("Ex: " + e);
        }
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
        // http://slick.ninjacave.com/forum/viewtopic.php?t=619  TECLADO SLICK2D
        animacoes.stop();
        // Entradas do jogo
        Input input = container.getInput();
        // Ações de movimentação - UP
        if (input.isKeyDown(Keyboard.KEY_W)) {
            if (getY() <= movableArea[1][0]) {
                return;
            }
            animacoes.setCurrent(AnimationEnum.UP);
            subY(delta * 0.1f);
        }
        // Ações de movimentação - DOWN
        if (input.isKeyDown(Keyboard.KEY_S)) {
            if (getY() >= movableArea[1][1]) {
                return;
            }
            animacoes.setCurrent(AnimationEnum.DOWN);
            addY(delta * 0.1f);
        }
        // Ações de movimentação - LEFT
        if (input.isKeyDown(Keyboard.KEY_A)) {
            if (getX() <= movableArea[0][0]) {
                return;
            }
            animacoes.setCurrent(AnimationEnum.LEFT);
            subX(delta * 0.1f);
        }
        // Ações de movimentação - RIGHT
        if (input.isKeyDown(Keyboard.KEY_D)) {
            if (getX() >= movableArea[0][1]) {
                return;
            }
            animacoes.setCurrent(AnimationEnum.RIGHT);
            addX(delta * 0.1f);
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
        animacoes.move(getX(), getY());
        animacoes.render(container, g);
    }

    /**
     * Método responsável por detectar colisões
     *
     * @param obj
     * @return
     */
    @Override
    public boolean isCollidingWith(SpacialElement obj) {
        return false;
    }

}
