package spring.mvcex.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import spring.mvcex.domain.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryMemberRepository  implements MemberRepository{
  private static Map<Long, Member> store = new HashMap<>();

  @Override
  public void save(Member member) {
    store.put(member.getId(), member);
  }

  @Override
  public Member findById(Long id) {
    Member member = store.get(id);
    return member;
  }

  @Override
  public List<Member> findAll() {
    return new ArrayList<>(store.values());
  }
}
