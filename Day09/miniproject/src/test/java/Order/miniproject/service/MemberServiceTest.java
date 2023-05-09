package Order.miniproject.service;

import Order.miniproject.domain.Address;
import Order.miniproject.domain.Member;
import Order.miniproject.domain.dto.MemberDto;
import Order.miniproject.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;



class MemberServiceTest {
  private final MemberService memberService;

  @Autowired
  public MemberServiceTest(MemberService memberService) {
    this.memberService = memberService;
  }

  @Test
  void join() {
    //given
    MemberDto member = new MemberDto();
    member.setName("test");
    Address address = new Address("seoul", "doksan", "11111");
    member.setAddress(address);
    //when
    Long joinId = memberService.join(member);
    // then

    Member oneMember = memberService.findOneMember(joinId);
    assertThat(member).isEqualTo(oneMember.getId());

  }

  @Test
  void findAllMembers() {
    //given
    MemberDto m1 = new MemberDto();
    m1.setName("test");
    Address address = new Address("seoul", "doksan", "11111");
    m1.setAddress(address);

    MemberDto m2 = new MemberDto();
    m2.setName("test");
    Address address1 = new Address("seoul", "kasan", "11112");
    m2.setAddress(address);
    //when
    Long joinId1 = memberService.join(m1);
    Long joinId2 = memberService.join(m2);
    // then
    List<Member> members = memberService.findAllMembers();
    assertThat(2).isEqualTo(members.size());
  }
}