package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingleTonTest {
  @Test
  @DisplayName("스프링 없는 순수 DI 컨테이너")
  void pureContainer() {
    AppConfig appConfig = new AppConfig();
    MemberService memberService1 = appConfig.memberService();
    MemberService memberService2 = appConfig.memberService();

    System.out.println("memberService1 : " + memberService1);
    System.out.println("memberService2 : " + memberService2);

    assertThat(memberService1).isNotEqualTo(memberService2);

  }

  @Test
  @DisplayName("싱글톤 패턴을 적용한 객체 사용")
  void singleTonServiceTest() {
//    new SingleTonService(); // private 이라서 불러올 수 없음

    SingleTonService instance = SingleTonService.getInstance();
    SingleTonService instance2 = SingleTonService.getInstance();

    System.out.println("singleTonService1 : " + instance);
    System.out.println("singleTonService2 : " + instance2);

    instance.logic();
    instance2.logic();

    assertThat(instance).isEqualTo(instance2);
  }


  @Test
  @DisplayName("스프링 컨테이너와 싱글톤")
  void springContainer() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    MemberService memberService1 = ac.getBean("memberService", MemberService.class);
    MemberService memberService2 = ac.getBean("memberService", MemberService.class);

    System.out.println("memberService1 : " + memberService1);
    System.out.println("memberService2 : " + memberService2);

    assertThat(memberService1).isSameAs(memberService2);
  }


}
