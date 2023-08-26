package horus.demo.messages.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

  @Autowired
  private RabbitTemplate template;

  @Autowired
  private Queue queue;

  public void enviar(String mensagem) {
    template.convertAndSend(queue.getName(), mensagem);
  }

}
