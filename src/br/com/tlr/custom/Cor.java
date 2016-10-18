/*
 * NewRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.custom;

import org.newdawn.slick.Color;

/**
 * Descrição da classe.
 */
public class Cor extends Color {

    public Cor(Color color) {
        super(color);
    }

    public static final String encode(Color color) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        sb.append(Integer.valueOf(String.valueOf(color.getRed()), 16));
        sb.append(Integer.valueOf(String.valueOf(color.getGreen()), 16));
        sb.append(Integer.valueOf(String.valueOf(color.getBlue()), 16));
        return sb.toString();
    }

}
