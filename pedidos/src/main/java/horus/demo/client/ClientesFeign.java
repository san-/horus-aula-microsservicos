package horus.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "clientes", url = "http://host.docker.internal:8888")
public interface ClientesFeign {

  @GetMapping(value = "/clientes/{codigo}")
  public Cliente buscarCliente(@PathVariable Integer codigo);
  
}
