package horus.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

  @Id
  public Integer codigo;
  public String nome;
  public String cidade;

}
