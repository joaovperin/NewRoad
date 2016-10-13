/*
 * TestLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.database;

/**
 * Identificadores dos possíveis tipos de item
 */
public enum ItemTypes {

    ARMA(1), ARMADURA(2);

    /** Identificador único do tipo do item */
    private final int type;

    /**
     * Construtor padrão do estado
     */
    private ItemTypes(int type) {
        this.type = type;
    }

    /**
     * Retorna o id tipo
     *
     * @return int
     */
    public int getType() {
        return type;
    }

    /**
     * Retorna o nome tipo
     *
     * @return String
     */
    public String getTypeDesc() {
        return this.toString();
    }

}
