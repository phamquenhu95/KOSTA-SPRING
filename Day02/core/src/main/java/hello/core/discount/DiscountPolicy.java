package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
  int discountAmount(Member member, int price);
}
