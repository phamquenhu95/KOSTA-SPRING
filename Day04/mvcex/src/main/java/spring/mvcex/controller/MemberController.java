package spring.mvcex.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.mvcex.domain.Member;
import spring.mvcex.domain.MemberDTO;
import spring.mvcex.repository.MemberRepository;
import spring.mvcex.repository.MemoryMemberRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

  private final MemberRepository memberRepository;
  private static long sequence = 1L;
  @GetMapping("/addMember") // 회원가입 - 회원
  public String addMember() {
    return "members/addMember";
  }

//  public ModelAndView process() {
//    return new ModelAndView("new-form");
//  }

  @PostMapping("/saveMember")
  public String saveMemberV1(@ModelAttribute("memberDTO") MemberDTO memberDTO) {
    ++sequence;

    Member member = new Member(sequence, memberDTO.getUsername(), memberDTO.getAge());
    memberRepository.save(member);
    return "redirect:/members/home";
  }
//  public String saveMember(@RequestParam("username") String username,
//                           @RequestParam("age") int age) {
//    ++sequence;
//    Member member = new Member(sequence, username, age);
//    memberRepository.save(member);
//    return "redirect:/members/home";
//  }

  @GetMapping("/memberList") // 회원목록 - 관리자
  public String memberList(Model model) {

    MemoryMemberRepository mmr = (MemoryMemberRepository)memberRepository;
    mmr.createMember();
    List<Member> members = memberRepository.findAll();
    model.addAttribute("members", members);
    return "members/memberList";
  }

  @GetMapping("/memberInfo") // 회원상세정보조회 - 관리자
  public String memberInfo(@RequestParam(value="id") Long id,
                            Model model) {


    Member findMember = memberRepository.findById(id);
    model.addAttribute("member", findMember);
    return "members/memberInfo";
  }
}
