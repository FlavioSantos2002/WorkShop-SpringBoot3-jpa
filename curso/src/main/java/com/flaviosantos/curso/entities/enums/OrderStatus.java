package com.flaviosantos.curso.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static OrderStatus valeOf(int code) {
		for (OrderStatus v: OrderStatus.values()) {
			if (v.getCode() == code) {
				return v;
			}
		}
		throw new IllegalArgumentException("codigo invalido");
	}
}
