import domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Member_remove {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPASample");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    System.out.println("삭제 트랜객션 시작");

    try {
      tx.begin();
      Member member1 = em.find(Member.class, 3L);

      System.out.println("영속 상태 ----------------");
      em.remove(member1);
      System.out.println("삭제 상태 ----------------");
//      Member member1 = em.find(Member.class, 1L);
//      Member member2 = em.find(Member.class, 1L);
//      System.out.println("member1 == member2 ? " + member1.equals(member2));
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
