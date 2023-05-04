import domain.Member;
import domain.RoleType;
import domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Member_Team_Fetch_Proxy {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPASample");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    System.out.println("멤버와 팀 페치: 트랜잭션 시작");

    try {
      tx.begin();
      Team team = em.find(Team.class, 1L);

      System.out.println("멤버 정보 가져오기 ----------------");
      Member m1 = em.find(Member.class, 1L);

      em.detach(team);
      em.detach(m1);
      em.clear();

      System.out.println("멤버 정보 가져오기 ----------------");

      Member fm0 = em.getReference(Member.class, m1.getId());

      System.out.println("fm0 object 의 run time class 출력하기 --------------------");
      System.out.println(fm0.getClass());
      System.out.println("ID 출력하기 --------------------");
      System.out.println(fm0.getId());
      System.out.println("userName 출력하기 --------------------");
      System.out.println(fm0.getUsername());
      System.out.println("팀 object의 정보 출력하기 --------------------");
      System.out.println(team.getClass());
      System.out.println("member의 소속 팀 ID 출력하기 --------------------");
      System.out.println(fm0.getTeam().getId());
      System.out.println("member의 소속 팀 이름 출력하기 --------------------");
      System.out.println(fm0.getTeam().getName());

      System.out.println("커밋 전 ----------------");
      tx.commit();
      System.out.println("커밋 후 ----------------");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}
