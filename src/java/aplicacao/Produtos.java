/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

/**
 *
 * @author marco
 */
public class Produtos {
   
    private int id;
    private String nome;
    private String descricao;
    private float precoCompra;
    private float precoVenda;
    private int qtdDisponivel;
    private String liberadoVenda;
    private int idCategoria;
    
    public Produtos(int id, String nome, String descricao, float precoCompra, float precoVenda, int qtdDisponivel,String liberadoVenda,int idCategoria){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.qtdDisponivel = qtdDisponivel;     
        this.liberadoVenda = liberadoVenda;
        this.idCategoria = idCategoria;
    }
    public Produtos(){   
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the precoCompra
     */
    public float getPrecoCompra() {
        return precoCompra;
    }

    /**
     * @param precoCompra the precoCompra to set
     */
    public void setPrecoCompra(float precoCompra) {
        this.precoCompra = precoCompra;
    }

    /**
     * @return the precoVenda
     */
    public float getPrecoVenda() {
        return precoVenda;
    }

    /**
     * @param precoVenda the precoVenda to set
     */
    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    /**
     * @return the qtdDisponivel
     */
    public int getQtdDisponivel() {
        return qtdDisponivel;
    }

    /**
     * @param qtdDisponivel the qtdDisponivel to set
     */
    public void setQtdDisponivel(int qtdDisponivel) {
        this.qtdDisponivel = qtdDisponivel;
    }
        /**
     * @return the liberadoVenda
     */
    public String getLiberadoVenda() {
        return liberadoVenda;
    }

    /**
     * @param liberadoVenda the liberadoVenda to set
     */
    public void setLiberadoVenda(String liberadoVenda) {
        this.liberadoVenda = liberadoVenda;
    }

    /**
     * @return the idCategoria
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * @param idCategoria the idCategoria to set
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    
    
    
}
