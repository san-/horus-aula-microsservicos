package horus.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

  @Id
  public Integer numero;
  public Integer codigoCliente;
  public Double valor;

}
