package clone.example.instagram.domain.feed.controller;

import clone.example.instagram.domain.feed.entity.member.Member;
import clone.example.instagram.domain.feed.repository.member.MemberRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public MemberController(MemberRepository memberRepository, BCryptPasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/login")
    public String getLoginPage(Model model,
                               @RequestParam(value = "error", required = false) String error,
                               @RequestParam(value = "exception",required = false) String exception){
        model.addAttribute("error",error);
        model.addAttribute("exception",exception);
        return "member/login";
    }

    @PostMapping("register")
    public String registerMember(@RequestParam("email") String email, @RequestParam("password") String password){

        String encryptedPassword = passwordEncoder.encode(password);

        Member member = Member.builder()
                .email(email)
                .pwd(encryptedPassword)
                .build();

        memberRepository.save(member);

        return "redirect:/login";
    }

}
