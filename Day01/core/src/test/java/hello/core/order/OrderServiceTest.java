//package hello.core.order;
//
//import hello.core.member.Grade;
//import hello.core.member.Member;
//import hello.core.member.MemberService;
//import hello.core.member.MemberServiceImpl;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class OrderServiceTest {
//  private static final MemberService memberService = new MemberServiceImpl();
//  private static final OrderService orderService = new OrderServiceImpl();
//
//
//  @Test
//  @DisplayName("vip 고객은 10% 할인 적용")
//  void VIP_주문생성테스트() {
//    // given
//    Member member2 = new Member(2L, "memberB", Grade.VIP);
//    memberService.join(member2);
//    // when
//    Order order2 = orderService.createOrder(2L, "itemB", 10000);
//    Order order3 = orderService.createOrder(2L, "itemB", 20000);
//    // then
//    assertThat(1000).isEqualTo(order2.getDiscountPrice());
//    assertThat(2000).isEqualTo(order3.getDiscountPrice());
//  }
//
//  @Test
//  @DisplayName("일반 고객은 할인 적용 안 됨")
//  void 일반주문생성테스트() {
//    // given
////    memberId++;
////    Long memberId = 1L;
//    Member member = new Member(1L, "memberA", Grade.BASIC);
//    memberService.join(member);
//   // when
//    Order order = orderService.createOrder(1L, "itemA", 10000);
//    // then
//    assertThat(0).isEqualTo(order.getDiscountPrice());
// }
//}
