package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
  private final int DISCOUNT_RATE = 10;
  @Override
  public int discountAmount(Member member, int price) {
    if(member.getGrade() == Grade.VIP) {
//      return price * 10/100;
      return price * DISCOUNT_RATE/100;

    } else {
      return 0;
    }
  }
}
