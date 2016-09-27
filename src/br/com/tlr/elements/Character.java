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

    /** Comando de correr */
//    protected Command run = new BasicCommand("Run");
//    /** Comando de atacar */
//    protected Command attack = new BasicCommand("Attack");


    // SUBSTITUIR POR ARRAYLIST
//    protected final Command walk = new BasicCommand(CommandEnum.WALK.getName());

    /** Comando moveUp */
//    protected final Command moveUp = new BasicCommand(AnimationEnum.UP.getName());
//    /** Comando moveDown */
//    protected final Command moveDown = new BasicCommand(AnimationEnum.DOWN.getName());
//    /** Comando moveLeft */
//    protected final Command moveLeft = new BasicCommand(AnimationEnum.LEFT.getName());
//    /** Comando moveRight */
//    protected final Command moveRight = new BasicCommand(AnimationEnum.RIGHT.getName());

    /**
     * Construtor padrão de um Character
     *
     * @param animationName Nome do arquivo de animações do personagem
     * @param numFrames Número de frames por sprite
     * @param movableArea Dimensões máximas do jogador
     */
    public Character(String animationName, int numFrames, float[][] movableArea) {
        this.animationName = animationName;
        this.numFrames = numFrames;
        this.movableArea = movableArea;
    }

}
