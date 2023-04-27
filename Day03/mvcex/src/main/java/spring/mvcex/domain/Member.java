package spring.mvcex.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
  private Long id;
  private String username;
  private int age;
}
