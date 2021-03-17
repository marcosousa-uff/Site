/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import java.sql.Date;

/**
 *
 * @author marco
 */
public class Vendas {

    private int id;
    private int qtdVenda;
    private Date data;
    private float valorVenda;
    private int idCliente;
    private int idProduto;
    private int idVendedor;

    public Vendas(int id,int qtdVenda, Date data, float valorVenda, int idCliente, int idProduto, int idVendedor) {

        this.id = id;
        this.qtdVenda = qtdVenda;
        this.data = data;
        this.valorVenda = valorVenda;
        this.idCliente = idCliente;
        this.idProduto = idProduto;
        this.idVendedor = idVendedor;

    }
    public Vendas(){
        
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
     * @return the valorVenda
     */
    public float getValorVenda() {
        return valorVenda;
    }

    /**
     * @param valorVenda the valorVenda to set
     */
    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
     * @return the idVendedor
     */
    public int getIdVendedor() {
        return idVendedor;
    }

    /**
     * @param idVendedor the idVendedor to set
     */
    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    /**
     * @return the qtdVenda
     */
    public int getQtdVenda() {
        return qtdVenda;
    }

    /**
     * @param qtdVenda the qtdVenda to set
     */
    public void setQtdVenda(int qtdVenda) {
        this.qtdVenda = qtdVenda;
    }

}
