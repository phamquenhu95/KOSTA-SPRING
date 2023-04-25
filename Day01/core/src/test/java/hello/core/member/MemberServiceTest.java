package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
  MemberService memberService;
//  = new MemberServiceImpl();

  @BeforeEach
  void setup() {
    AppConfig appConfig = new AppConfig();
    memberService = appConfig.memberService();
  }
  @Test
  void 회원가입테스트(){
    // 테스트데이터생성 (화면에서 사용자의 입력을 대신), 메서드를 실행, 결과를 확인
    // given
    Member member = new Member(1L, "testA", Grade.BASIC);
    Member member2 = new Member(2L, "testB", Grade.VIP);
    // when
    memberService.join(member);
    memberService.join(member2);
    Member findMember = memberService.findMember(2L);
    // then
    System.out.println(member);
    System.out.println(findMember);

//    Assertions.assertEquals(member, findMember);
    Assertions.assertThat(findMember).isEqualTo(member2); // 순서 상관없음 Aseertion 2번째줄

  }

}
