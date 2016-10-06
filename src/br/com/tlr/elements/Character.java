/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tlr.elements;

import br.com.tlr.encapsulation.Animacoes;

/**
 * Classe responsável pela criação de personagens
 *
 * @author JOAO
 */
public abstract class Character extends Movable implements Animable {

    /** Nome da animaçao */
    protected final String animationName;
    /** Quadro máximo que os players podem se mover */
    protected final float[][] movableArea;
    /** Número de quadros por animação do personagem */
    protected final int numFrames;

    // Array de animações (Reestruturar para ser possível de tornar FINAL)
    protected Animacoes animacoes;

    /**
     * Construtor padrão de um Character
     *
     * @param animationName Nome do arquivo de animações do personagem
     * @param numFrames Número de frames por sprite
     * @param movableArea Dimensões máximas do jogador
     */
    public Character(String animationName, int numFrames, float[][] movableArea) {
        super(32, 48);
        this.animationName = animationName;
        this.numFrames = numFrames;
        this.movableArea = movableArea;
    }

}
