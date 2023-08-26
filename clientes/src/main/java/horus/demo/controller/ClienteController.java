package horus.demo.controller;

import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import horus.demo.messages.producer.MessageProducer;
import horus.demo.model.Cliente;
import horus.demo.persistence.ClientePersistence;

@RestController
public class ClienteController {

  @Autowired
  private ClientePersistence clienteRepository;

  @Autowired
  private MessageProducer producer;

  @GetMapping(path = "/clientes")
  public List<Cliente> listarClientes(){
    return  clienteRepository.findAll();
  }

  @GetMapping(path = "/clientes/{codigo}")
  public Cliente buscarCliente(@PathVariable Integer codigo){
    return clienteRepository.findById(codigo).orElseThrow();
  }

  @GetMapping("/clientes/mensagem")
  public String enviarMensagemRabbit(@RequestParam String t){
    if (Strings.isEmpty(t))
      t = "Texto enviado para o RabbitMQ";
    producer.enviar(t);
    return "Mensagem enviada";
  }
  
}
