package horus.demo.messages;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fila1")
public class ProcessarMensagemRecebida {

  @RabbitHandler
  public void receive(String mensagem) {
    System.out.println(" [x] Mensagem recebida: '" + mensagem + "'");
  }
  
}
