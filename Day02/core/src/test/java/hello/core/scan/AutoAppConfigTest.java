package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {

  @Test
  void basicScan() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
    MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
//    assertThat(memberService).isInstanceOf(MemberService.class);
    assertThat(memberService.getMemberRepository()).isInstanceOf(MemberRepository.class);

  }

  @Test
  void setterScan() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
    OrderService orderService = ac.getBean(OrderService.class);
//    assertThat(memberService).isInstanceOf(MemberService.class);
    assertThat(orderService).isInstanceOf(OrderService.class);

  }
}
