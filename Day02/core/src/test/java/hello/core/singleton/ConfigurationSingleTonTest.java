package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingleTonTest {
  @Test
  void configurationTest() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
    OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
    MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

    System.out.println(memberService.getMemberRepository());
    System.out.println(orderService.getMemberRepository());
    System.out.println(memberRepository);

    assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
    assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
  }
}
