package com.github.manojesus.padroesdeprojetospring.service;

import com.github.manojesus.padroesdeprojetospring.exception.ClienteJaExistenteException;
import com.github.manojesus.padroesdeprojetospring.exception.ClienteNaoEncontradoException;
import com.github.manojesus.padroesdeprojetospring.model.Cliente;
import com.github.manojesus.padroesdeprojetospring.model.ClienteRepository;
import com.github.manojesus.padroesdeprojetospring.model.Endereco;
import com.github.manojesus.padroesdeprojetospring.model.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{
    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;
    private final ViaCepService viaCepService;

    public ClienteServiceImpl(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository, ViaCepService viaCepService) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
        this.viaCepService = viaCepService;
    }


    @Override
    public Cliente buscarCliente(String id) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        return optionalCliente.orElseThrow(() -> new ClienteNaoEncontradoException("cliente com id "+id+" nao encontrado"));
    }

    @Override
    public Iterable<Cliente> buscarTodosClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public void salvarClente(Cliente cliente) {
        if(clienteRepository.existsById(cliente.getCpf())){
            throw new ClienteJaExistenteException("Cliente ja existe");
        }else{
            salvarClienteComEnderecoCompleto(cliente);
        }
    }

    @Override
    public void atualizarCliente(String id, Cliente cliente) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        if(optionalCliente.isPresent()){
            Cliente clienteBD = optionalCliente.get();
            if(!cliente.getNome().equals(clienteBD.getNome())){
                cliente.setNome(clienteBD.getNome());
            }
            salvarClienteComEnderecoCompleto(cliente);
        }else{
            throw new ClienteNaoEncontradoException("O cliente com ID "+id+" nao existe");
        }
    }

    @Override
    public void deletarCliente(String id) {
        if(clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        }else{
            throw new ClienteNaoEncontradoException("O cliente com ID "+id+" nao existe");
        }
    }

    private void salvarClienteComEnderecoCompleto(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.getEnderecoByCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
