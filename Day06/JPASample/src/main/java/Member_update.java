import domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Member_update {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPASample");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    System.out.println("업데이트 트랜객션 시작");

    try {
      tx.begin();
      Member fMember = em.find(Member.class, 1L);

      System.out.println("영속 상태 수정전 ----------------" + fMember.getName());
      fMember.setName("updateMember");
      System.out.println("영속 상태 수정후 ----------------" + fMember.getName());


//em.merge(fMember); em.update();em.persist();

//      Member member1 = em.find(Member.class, 1L);
//      Member member2 = em.find(Member.class, 1L);
//      System.out.println("member1 == member2 ? " + member1.equals(member2));
      System.out.println("커밋 전 ----------------");
      tx.commit();
      System.out.println("커밋 후 ----------------");
      Member fMember2 = em.find(Member.class, 1L);
      System.out.println("fMember2 == member1 ? " + fMember.equals(fMember2));

    } catch (Exception e) {
      System.out.println(e.getMessage());
      tx.rollback();
    } finally {
      em.close();
    }
    emf.close();
  }
}
