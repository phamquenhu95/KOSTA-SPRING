package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class OrderApp {
  public static void main(String[] args) {
    AppConfig appConfig = new AppConfig();

    MemberService memberService = appConfig.memberService();
    Member member = new Member(1L, "MemberA", Grade.VIP);
    memberService.join(member);

    OrderService orderService = appConfig.orderService();
    Order order = orderService.createOrder(1L, "itemA", 10000);

    System.out.println("new Order : " + order.getMemberId());
    System.out.println("find Order : " + order.getDiscountPrice());



  }
}
