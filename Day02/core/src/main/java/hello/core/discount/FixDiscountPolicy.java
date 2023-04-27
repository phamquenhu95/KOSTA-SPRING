package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
  private final int DISCOUNT_AMOUNT = 1000;
  @Override
  public int discountAmount(Member member, int price) {
    if(member.getGrade() == Grade.VIP) {
      return DISCOUNT_AMOUNT;
    } else {
      return 0;
    }
  }
}
