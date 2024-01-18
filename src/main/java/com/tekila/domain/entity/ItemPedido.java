package com.tekila.domain.entity;

public class ItemPedido {
	private Integer id;
	private Pedido Pedido;
	private Produto produto;
	private Integer quantidade;
	public ItemPedido() {
		
	}
	public ItemPedido(Integer id, com.tekila.domain.entity.Pedido pedido, Produto produto, Integer quantidade) {
		super();
		this.id = id;
		Pedido = pedido;
		this.produto = produto;
		this.quantidade = quantidade;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Pedido getPedido() {
		return Pedido;
	}
	public void setPedido(Pedido pedido) {
		Pedido = pedido;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
