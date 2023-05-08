package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class NewMember {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @Embedded
  private Address address;

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  @OneToMany(mappedBy ="member")
  public List<Orders> orders = new ArrayList<>();



  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  }
