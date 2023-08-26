package horus.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import horus.demo.client.ClientesFeign;
import horus.demo.model.Pedido;
import horus.demo.persistence.PedidoPersistence;

@RestController
public class PedidoController {

  @Autowired
  private PedidoPersistence pedidoRepository;

  @Autowired
  private ClientesFeign clientes;

  @GetMapping(path = "/pedidos")
  public List<Pedido> listarPedidos(){
    var pedidos =  pedidoRepository.findAll();
    return pedidos;
  }

  @GetMapping(path = "/pedidos/{codigo}")
  public PedidoResposta buscarPedido(@PathVariable Integer codigo){
    var pedido =  pedidoRepository.findById(codigo).orElseThrow();
    var cliente = clientes.buscarCliente(pedido.codigoCliente);
    var resposta = new PedidoResposta();
    resposta.cliente = cliente;
    resposta.numero = pedido.numero;
    resposta.valor = pedido.valor;
    return resposta;
  }

  
  
}
