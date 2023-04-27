package spring.mvcex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import spring.mvcex.domain.Member;
import spring.mvcex.repository.MemberRepository;
import spring.mvcex.repository.MemoryMemberRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SpringMvcController {
  @RequestMapping("/members/new-form")
  public String process() {
    return "members/new-form";
  }

//  public ModelAndView process() {
//    return new ModelAndView("new-form");
//  }

  @RequestMapping("/members/save-member")
  public String saveMember() {
    return "members/save-member";


  }

  @RequestMapping("/members/memberlist")
  public String memberList(Model model) {
    MemberRepository memberRepository = new MemoryMemberRepository();
    List<Member> members = memberRepository.findAll();
    model.addAttribute("members", members);
    return "members/memberlist";
  }
}
