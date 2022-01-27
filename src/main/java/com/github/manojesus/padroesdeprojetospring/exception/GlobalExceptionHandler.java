package com.github.manojesus.padroesdeprojetospring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ClienteJaExistenteException.class)
    public ResponseEntity<String> clienteJaExisteExcpetion(ClienteJaExistenteException clienteJaExistenteException){
        return new ResponseEntity<>(clienteJaExistenteException.getMessage(), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(value = ClienteNaoEncontradoException.class)
    public ResponseEntity<String> clientenaoEncontrado(ClienteNaoEncontradoException clienteNaoEncontradoException){
        return new ResponseEntity<>(clienteNaoEncontradoException.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> databaseConnectionFailsException(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
