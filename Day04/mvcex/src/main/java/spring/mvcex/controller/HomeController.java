package spring.mvcex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.mvcex.domain.Member;
import spring.mvcex.repository.MemberRepository;
import spring.mvcex.repository.MemoryMemberRepository;

import java.util.List;

@Controller
public class HomeController {
 @RequestMapping(value="/home")
  public String home() {
   return "home";
 }
  @RequestMapping(value="/members/home")
  public String memberHome() {
    return "members/memberHome";
  }
}
