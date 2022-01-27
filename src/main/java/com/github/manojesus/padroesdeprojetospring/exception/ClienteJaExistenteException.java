package com.github.manojesus.padroesdeprojetospring.exception;

public class ClienteJaExistenteException extends RuntimeException{
    private String mensagem;

    public ClienteJaExistenteException(String mensagem) {
        super(mensagem);
        this.mensagem = mensagem;
    }

    public ClienteJaExistenteException() {
    }
}
