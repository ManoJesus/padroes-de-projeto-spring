package com.github.manojesus.padroesdeprojetospring.controller;

import com.github.manojesus.padroesdeprojetospring.model.Cliente;
import com.github.manojesus.padroesdeprojetospring.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0/cleintes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodosClientes(){
        return new ResponseEntity<>(clienteService.buscarTodosClientes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable("id") String id){
        return new ResponseEntity<>(clienteService.buscarCliente(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente){
        clienteService.salvarClente(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarDadosCliente(@PathVariable String id, @RequestBody Cliente cliente){
        clienteService.atualizarCliente(id, cliente);
        return new ResponseEntity<>(cliente, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable String id){
        clienteService.deletarCliente(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
