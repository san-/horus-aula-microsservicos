package horus.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import horus.demo.model.Pedido;

@Repository
public interface PedidoPersistence extends JpaRepository<Pedido, Integer>  {
  
}
