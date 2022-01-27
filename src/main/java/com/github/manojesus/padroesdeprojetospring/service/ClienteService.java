package com.github.manojesus.padroesdeprojetospring.service;

import com.github.manojesus.padroesdeprojetospring.exception.ClienteJaExistenteException;
import com.github.manojesus.padroesdeprojetospring.exception.ClienteNaoEncontradoException;
import com.github.manojesus.padroesdeprojetospring.model.Cliente;
import org.springframework.stereotype.Service;


public interface ClienteService {

    Cliente buscarCliente (String id) throws ClienteNaoEncontradoException;

    Iterable<Cliente> buscarTodosClientes();

    void salvarClente(Cliente cliente) throws ClienteJaExistenteException;

    void atualizarCliente(String id,Cliente cliente) throws ClienteNaoEncontradoException;

    void deletarCliente(String id) throws ClienteNaoEncontradoException;

}
