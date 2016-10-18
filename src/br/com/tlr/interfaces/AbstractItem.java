/*
 * NewRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.interfaces;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Vector2f;

/**
 * Entidade abstrata que representa um item
 */
public abstract class AbstractItem {

    private int id;

    private int width;
    private int height;
    private Vector2f position;
    private Vector2f velocity;
    private int type;
    private String name;

    private boolean questItem;
    private int damage;
    private int defense;
    private float knockBack;
    private int healLife;
    private int healMana;

    private int stack;
    private int maxStack;
    private boolean consumable;

    private Color color;
    private int alpha;

    private float scale = 1f;

    private boolean equippable;
    private int headSlot = -1;
    private int bodySlot = -1;
    private int legSlot = -1;

//    private override string ToString(){
//
//    }

}
