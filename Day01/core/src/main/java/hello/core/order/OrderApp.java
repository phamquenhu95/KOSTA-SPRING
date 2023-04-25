package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class OrderApp {
  public static void main(String[] args) {
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    Member member = new Member(2L,"MemberB", Grade.VIP);
    memberService.join(member);
    Member findMember = memberService.findMember(2L);
    Order order = orderService.createOrder(2L, "itemA", 20000);
    System.out.println(findMember.getName() + ":" + findMember.getGrade());
    System.out.println("주문금액 : " + order.getItemPrice() + ", 할인금액 : " + order.getDiscountPrice()+
        ", 할인적2용금액 : " + order.calculatePrice());
  }
}


//public class OrderApp {
//  public static void main(String[] args) {
//    AppConfig appConfig = new AppConfig();
//
//    MemberService memberService = appConfig.memberService();
//    Member member = new Member(1L, "MemberA", Grade.VIP);
//    memberService.join(member);
//
//    OrderService orderService = appConfig.orderService();
//    Order order = orderService.createOrder(1L, "itemA", 10000);
//
//    System.out.println("new Order : " + order.getMemberId());
//    System.out.println("find Order : " + order.getDiscountPrice());
//
//
//
//  }
//}
