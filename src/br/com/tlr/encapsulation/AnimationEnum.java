/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tlr.encapsulation;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.geom.Vector2f;

/**
 * Enumerado das animações default
 *
 * @author 0199831
 */
public enum AnimationEnum {

    UP(Keyboard.KEY_UP, (Vector2f pos) -> {   // Alterar as entradas para keyUP, keyDown, etc
        pos.y -= AnimationEnum.INCREMENT;
    }),
    DOWN(Keyboard.KEY_DOWN, (Vector2f pos) -> {
        pos.y += AnimationEnum.INCREMENT;
    }),
    LEFT(Keyboard.KEY_LEFT, (Vector2f pos) -> {
        pos.x -= AnimationEnum.INCREMENT;
    }),
    RIGHT(Keyboard.KEY_RIGHT, (Vector2f pos) -> {
        pos.x += AnimationEnum.INCREMENT;
    });

    public static final float INCREMENT = 0.1f;

    /** Código da animação */
    private final int code;
    /** Nome da animação */
    private final String name;
    /** Move */
    private final Move move;

    /**
     * Construtor padrão
     *
     * @param code Código da animação
     */
    AnimationEnum(int code, Move move) {
        this.code = code;
        this.name = Keyboard.getKeyName(code);
        this.move = move;
    }

    /**
     * Retorna o código da animação
     *
     * @return short
     */
//    public int getCode() {
//        return code;
//    }

    /**
     * Retorna o nome da animação
     *
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Retorna o movimento da animação
     *
     * @return String
     */
    public Move getMove() {
        return move;
    }

    public int getOrder(){
        AnimationEnum[] list = AnimationEnum.getAll();
//        for (int i = 0; i < list.length; i++){
//            if (list[i] == );
//        }

        if (code == Keyboard.KEY_LEFT) return 2;
        if (code == Keyboard.KEY_RIGHT) return 3;
        if (code == Keyboard.KEY_UP) return 0;
        if (code == Keyboard.KEY_DOWN) return 1;

        // elaborar
        return 0;
    }

    /**
     * Retorna todas as entradas no enumerado
     *
     * @return AnimationEnum[]
     */
    public static AnimationEnum[] getAll() {
        return AnimationEnum.values();
    }

    public static AnimationEnum getByName(int key) {
        for (AnimationEnum a : AnimationEnum.getAll()) {
//            if (a.getCode() == key) {
//                return a;
//            }
        }
        return null;
    }

}
