package com.estoque.exception;

public class ConexaoException extends RuntimeException {
	
	public ConexaoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
