package com.integrado.pizza.Controller;

import com.integrado.pizza.DTOs.PedidosRequestDTO;
import com.integrado.pizza.DTOs.PedidosResponseDTO;
import com.integrado.pizza.Model.Pedidos;
import com.integrado.pizza.Model.Cliente;
import com.integrado.pizza.Model.Endereco;
import com.integrado.pizza.Repository.PedidosRepository;
import com.integrado.pizza.Repository.ClienteRepository;
import com.integrado.pizza.Repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {

    @Autowired
    private PedidosRepository pedidosRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping // Mapeia requisições GET para /api/pedidos.
    public ResponseEntity<List<PedidosResponseDTO>> findAll() {
        List<Pedidos> pedidos = this.pedidosRepository.findAll(); // Busca todos os pedidos no banco de dados.
        List<PedidosResponseDTO> pedidosDTOs = pedidos.stream()
                .map(pedido -> new PedidosResponseDTO(
                        pedido.getId_pedido(),
                        pedido.getData_pedido(),
                        pedido.getId_cliente().getId_cliente(),
                        pedido.getId_endereco_entrega().getId_endereco()))
                .collect(Collectors.toList()); // Converte a lista de pedidos para uma lista de PedidosResponseDTO.
        return ResponseEntity.ok(pedidosDTOs); // Retorna a lista de pedidos com status OK (200).
    }

    @GetMapping("/{id}") // Mapeia requisições GET para /api/pedidos/{id}.
    public ResponseEntity<PedidosResponseDTO> findById(@PathVariable Long id) {
        Pedidos pedido = pedidosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado com id: " + id)); // Busca um pedido pelo ID.
        PedidosResponseDTO pedidoDTO = new PedidosResponseDTO(
                pedido.getId_pedido(),
                pedido.getData_pedido(),
                pedido.getId_cliente().getId_cliente(),
                pedido.getId_endereco_entrega().getId_endereco()); // Converte o pedido para PedidosResponseDTO.
        return ResponseEntity.ok(pedidoDTO); // Retorna o pedido encontrado com status OK (200).
    }

    @PostMapping // Mapeia requisições POST para /api/pedidos.
    public PedidosResponseDTO createPedido(@RequestBody PedidosRequestDTO dto) {
        Pedidos pedido = new Pedidos();
        Cliente cliente = clienteRepository.findById(dto.idCliente())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado com id: " + dto.idCliente()));
        Endereco endereco = enderecoRepository.findById(dto.idEnderecoEntrega())
                .orElseThrow(() -> new IllegalArgumentException("Endereço não encontrado com id: " + dto.idEnderecoEntrega()));

        pedido.setData_pedido(dto.dataPedido());
        pedido.setId_cliente(cliente);
        pedido.setId_endereco_entrega(endereco);

        Pedidos savedPedido = pedidosRepository.save(pedido); // Cria um novo pedido e salva no banco de dados.
        return new PedidosResponseDTO(
                savedPedido.getId_pedido(),
                savedPedido.getData_pedido(),
                savedPedido.getId_cliente().getId_cliente(),
                savedPedido.getId_endereco_entrega().getId_endereco()); // Converte o pedido salvo para PedidosResponseDTO e retorna.
    }

    @PutMapping("/{id}") // Mapeia requisições PUT para /api/pedidos/{id}.
    public ResponseEntity<PedidosResponseDTO> updatePedido(@PathVariable Long id, @RequestBody PedidosRequestDTO dto) {
        Pedidos pedido = pedidosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado com id: " + id)); // Busca o pedido pelo ID.

        Cliente cliente = clienteRepository.findById(dto.idCliente())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado com id: " + dto.idCliente()));
        Endereco endereco = enderecoRepository.findById(dto.idEnderecoEntrega())
                .orElseThrow(() -> new IllegalArgumentException("Endereço não encontrado com id: " + dto.idEnderecoEntrega()));

        pedido.setData_pedido(dto.dataPedido());
        pedido.setId_cliente(cliente);
        pedido.setId_endereco_entrega(endereco);

        Pedidos updatedPedido = pedidosRepository.save(pedido); // Salva as alterações no pedido.
        return ResponseEntity.ok(new PedidosResponseDTO(
                updatedPedido.getId_pedido(),
                updatedPedido.getData_pedido(),
                updatedPedido.getId_cliente().getId_cliente(),
                updatedPedido.getId_endereco_entrega().getId_endereco())); // Converte o pedido atualizado para PedidosResponseDTO e retorna.
    }

    @DeleteMapping("/{id}") // Mapeia requisições DELETE para /api/pedidos/{id}.
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        Pedidos pedido = pedidosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado com id: " + id)); // Busca o pedido pelo ID.

        pedidosRepository.delete(pedido); // Exclui o pedido do banco de dados.
        return ResponseEntity.noContent().build(); // Retorna status No Content (204).
    }
}
