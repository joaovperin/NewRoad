/*
 * TestLonelyRoad
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.com.tlr.database;

import br.com.tlr.elements.Item;

/**
 * Identificadores das armas do jogo
 */
public enum Itens {

    ESPADA(null), ARCO(null);
    /** Item */
    private final int idItem;
    /** Item */
    private final Item item;

    /**
     * Construtor padrão do estado
     */
    private Itens(Item item) {
        this.idItem = item.getId();
        this.item = item;
    }

    /**
     * Retorna o id do item
     *
     * @return int
     */
    public int getId() {
        return idItem;
    }

    /**
     * Retorna o item carregado em memória
     *
     * @return int
     */
    public Item getItem() {
        return item;
    }

}
