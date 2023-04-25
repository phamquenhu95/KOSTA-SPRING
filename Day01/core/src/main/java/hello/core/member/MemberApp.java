package hello.core.member;

import hello.core.AppConfig;

public class MemberApp {
  public static void main(String[] args) {
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    Member member = new Member(1L, "MemberA", Grade.BASIC);
    memberService.join(member);
    Member findMember = memberService.findMember(1L);
    System.out.println("new Member : " + member.getName());
    System.out.println("find Member : " + findMember.getName());
  }
}
