package com.integrado.pizza.Controller;

import com.integrado.pizza.DTOs.EnderecoRequestDTO;
import com.integrado.pizza.DTOs.EnderecoResponseDTO;
import com.integrado.pizza.Model.Endereco;
import com.integrado.pizza.Repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoRepository repository;

    @GetMapping // Mapeia requisições GET para /api/enderecos.
    public ResponseEntity<List<EnderecoResponseDTO>> findAll() {
        List<Endereco> enderecos = this.repository.findAll(); // Busca todos os endereços no banco de dados.
        List<EnderecoResponseDTO> enderecoDTOs = enderecos.stream()
                .map(endereco -> new EnderecoResponseDTO(
                        endereco.getId_endereco(),
                        endereco.getDescricaoLocal(),
                        endereco.getNumero(),
                        endereco.getBairro(),
                        endereco.getCidade(),
                        endereco.getEstado(),
                        endereco.getCep(),
                        endereco.getComplemento()))
                .collect(Collectors.toList()); // Converte a lista de endereços para uma lista de EnderecoResponseDTO.
        return ResponseEntity.ok(enderecoDTOs); // Retorna a lista de endereços com status OK (200).
    }

    @GetMapping("/{id}") // Mapeia requisições GET para /api/enderecos/{id}.
    public ResponseEntity<EnderecoResponseDTO> findById(@PathVariable Long id) {
        Endereco endereco = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Endereço não encontrado com id: " + id)); // Busca um endereço pelo ID.
        EnderecoResponseDTO enderecoDTO = new EnderecoResponseDTO(
                endereco.getId_endereco(),
                endereco.getDescricaoLocal(),
                endereco.getNumero(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getCep(),
                endereco.getComplemento()); // Converte o endereço para EnderecoResponseDTO.
        return ResponseEntity.ok(enderecoDTO); // Retorna o endereço encontrado com status OK (200).
    }

    @PostMapping // Mapeia requisições POST para /api/enderecos.
    public EnderecoResponseDTO createEndereco(@RequestBody EnderecoRequestDTO dto) {
        Endereco endereco = new Endereco();
        endereco.setDescricaoLocal(dto.descricaoLocal());
        endereco.setNumero(dto.numero());
        endereco.setBairro(dto.bairro());
        endereco.setCidade(dto.cidade());
        endereco.setEstado(dto.estado());
        endereco.setCep(dto.cep());
        endereco.setComplemento(dto.complemento());

        Endereco savedEndereco = repository.save(endereco); // Cria um novo endereço e salva no banco de dados.
        return new EnderecoResponseDTO(
                savedEndereco.getId_endereco(),
                savedEndereco.getDescricaoLocal(),
                savedEndereco.getNumero(),
                savedEndereco.getBairro(),
                savedEndereco.getCidade(),
                savedEndereco.getEstado(),
                savedEndereco.getCep(),
                savedEndereco.getComplemento()); // Converte o endereço salvo para EnderecoResponseDTO e retorna.
    }

    @PutMapping("/{id}") // Mapeia requisições PUT para /api/enderecos/{id}.
    public ResponseEntity<EnderecoResponseDTO> updateEndereco(@PathVariable Long id, @RequestBody EnderecoRequestDTO dto) {
        Endereco endereco = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Endereço não encontrado com id: " + id)); // Busca o endereço pelo ID.

        endereco.setDescricaoLocal(dto.descricaoLocal());
        endereco.setNumero(dto.numero());
        endereco.setBairro(dto.bairro());
        endereco.setCidade(dto.cidade());
        endereco.setEstado(dto.estado());
        endereco.setCep(dto.cep());
        endereco.setComplemento(dto.complemento());

        Endereco updatedEndereco = repository.save(endereco); // Salva as alterações no endereço.
        return ResponseEntity.ok(new EnderecoResponseDTO(
                updatedEndereco.getId_endereco(),
                updatedEndereco.getDescricaoLocal(),
                updatedEndereco.getNumero(),
                updatedEndereco.getBairro(),
                updatedEndereco.getCidade(),
                updatedEndereco.getEstado(),
                updatedEndereco.getCep(),
                updatedEndereco.getComplemento())); // Converte o endereço atualizado para EnderecoResponseDTO e retorna.
    }

    @DeleteMapping("/{id}") // Mapeia requisições DELETE para /api/enderecos/{id}.
    public ResponseEntity<Void> deleteEndereco(@PathVariable Long id) {
        Endereco endereco = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Endereço não encontrado com id: " + id)); // Busca o endereço pelo ID.

        repository.delete(endereco); // Exclui o endereço do banco de dados.
        return ResponseEntity.noContent().build(); // Retorna status No Content (204).
    }
}
