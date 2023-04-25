package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
  private final MemberRepository memberRepository;
//      = new MemoryMemberRepository();
//  private final DiscountPolicy discountPolicy = new FixAmountDiscount();
  private final DiscountPolicy discountPolicy;
//    = new RateDiscountPolicy();

  public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
  }

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {

    Member member = memberRepository.findById(memberId);

    int discount = discountPolicy.discountAmount(member, itemPrice);
    Order order = new Order(memberId, itemName, itemPrice, discount);
    return order;
  }
}
