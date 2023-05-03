import domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Member_create {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPASample");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    System.out.println("AI-PK: 생성 트랜객션 시작");

    try {
      tx.begin();
      Member member = new Member();
      member.setName("memberB");

      Member memberA = new Member();
      memberA.setName("memberC");

      System.out.println("비영속 상태 ----------------");
      em.persist(member);
      em.persist(memberA);
      System.out.println("영속 상태 ----------------");
      Member member1 = em.find(Member.class, member.getId());
      System.out.println("member == member1 ? " + member.equals(member1));
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
