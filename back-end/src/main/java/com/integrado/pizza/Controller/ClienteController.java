package com.integrado.pizza.Controller;

import com.integrado.pizza.DTOs.ClienteRequestDTO;
import com.integrado.pizza.DTOs.ClienteResponseDTO;
import com.integrado.pizza.Model.Cliente;
import com.integrado.pizza.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping // Mapeia requisições GET para /api/clientes.
    public ResponseEntity<List<ClienteResponseDTO>> findAll() {
        List<Cliente> clientes = this.repository.findAll(); // Busca todos os clientes no banco de dados.
        List<ClienteResponseDTO> clienteDTOs = clientes.stream()
                .map(cliente -> new ClienteResponseDTO(
                        cliente.getId_cliente(),
                        cliente.getNome(),
                        cliente.getEmail(),
                        cliente.getTelefone(),
                        cliente.getCpf()))
                .collect(Collectors.toList()); // Converte a lista de clientes para uma lista de ClienteResponseDTO.
        return ResponseEntity.ok(clienteDTOs); // Retorna a lista de clientes.
    }

    @GetMapping("/{id}") // Mapeia requisições GET para /api/clientes/{id}.
    public ResponseEntity<ClienteResponseDTO> findById(@PathVariable Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado com id: " + id)); // Busca um cliente pelo ID.
        ClienteResponseDTO clienteDTO = new ClienteResponseDTO(
                cliente.getId_cliente(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getCpf()); // Converte o cliente para ClienteResponseDTO.
        return ResponseEntity.ok(clienteDTO); // Retorna o cliente encontrado com status OK (200).
    }

    @PostMapping // Mapeia requisições POST para /api/clientes.
    public ClienteResponseDTO createCliente(@RequestBody ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.nome());
        cliente.setEmail(dto.email());
        cliente.setTelefone(dto.telefone());
        cliente.setCpf(dto.cpf());

        Cliente savedCliente = repository.save(cliente); // Cria um novo cliente e salva no banco de dados.
        return new ClienteResponseDTO(
                savedCliente.getId_cliente(),
                savedCliente.getNome(),
                savedCliente.getEmail(),
                savedCliente.getTelefone(),
                savedCliente.getCpf()); // Converte o cliente salvo para ClienteResponseDTO e retorna.
    }

    @PutMapping("/{id}") // Mapeia requisições PUT para /api/clientes/{id}.
    public ResponseEntity<ClienteResponseDTO> updateCliente(@PathVariable Long id, @RequestBody ClienteRequestDTO dto) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado com id: " + id)); // Busca o cliente pelo ID.

        cliente.setNome(dto.nome());
        cliente.setEmail(dto.email());
        cliente.setTelefone(dto.telefone());
        cliente.setCpf(dto.cpf());

        Cliente updatedCliente = repository.save(cliente); // Salva as alterações no cliente.
        return ResponseEntity.ok(new ClienteResponseDTO(
                updatedCliente.getId_cliente(),
                updatedCliente.getNome(),
                updatedCliente.getEmail(),
                updatedCliente.getTelefone(),
                updatedCliente.getCpf())); // Converte o cliente atualizado para ClienteResponseDTO e retorna.
    }

    @DeleteMapping("/{id}") // Mapeia requisições DELETE para /api/clientes/{id}.
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado com id: " + id)); // Busca o cliente pelo ID.

        repository.delete(cliente); // Exclui o cliente do banco de dados.
        return ResponseEntity.noContent().build(); // Retorna status No Content (204).
    }
}
