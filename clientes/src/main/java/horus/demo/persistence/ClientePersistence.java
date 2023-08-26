package horus.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import horus.demo.model.Cliente;

@Repository
public interface ClientePersistence extends JpaRepository<Cliente, Integer>  {
  
}
