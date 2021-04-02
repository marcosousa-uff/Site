/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import java.sql.Date;

/**
 *
 * @author cliente
 */
public class Compra {
    private int id;
    private int qtdCompra;
    private Date data;
    private float valorCompra;
    private int idFornecedor;
    private int idProduto;
    private int idComprador;

    public Compra(int id,int qtdCompra, Date data, float valorCompra, int idFornecedor, int idProduto, int idComprador) {

        this.id = id;
        this.qtdCompra = qtdCompra;
        this.data = data;
        this.valorCompra = valorCompra;
        this.idFornecedor = idFornecedor;
        this.idProduto = idProduto;
        this.idComprador = idComprador;

    }
    public Compra(){
        
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
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the valorCompra
     */
    public float getValorCompra() {
        return valorCompra;
    }

    /**
     * @param valorCompra the valorCompra to set
     */
    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }

    /**
     * @return the idFornecedor
     */
    public int getIdFornecedor() {
        return idFornecedor;
    }

    /**
     * @param idFornecedor the idFornecedor to set
     */
    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    /**
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the idComprador
     */
    public int getIdComprador() {
        return idComprador;
    }

    /**
     * @param idComprador the idComprador to set
     */
    public void setIdComprador(int idComprador) {
        this.idComprador = idComprador;
    }

    /**
     * @return the qtdCompra
     */
    public int getQtdCompra() {
        return qtdCompra;
    }

    /**
     * @param qtdCompra the qtdCompra to set
     */
    public void setQtdCompra(int qtdCompra) {
        this.qtdCompra = qtdCompra;
    }

    
}
