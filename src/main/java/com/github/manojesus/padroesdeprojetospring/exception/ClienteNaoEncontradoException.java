package com.github.manojesus.padroesdeprojetospring.exception;

public class ClienteNaoEncontradoException extends RuntimeException{
    private String mensagem;

    public ClienteNaoEncontradoException(String mensagem) {
        super(mensagem);
        this.mensagem = mensagem;
    }
    public ClienteNaoEncontradoException() {
    }
}
