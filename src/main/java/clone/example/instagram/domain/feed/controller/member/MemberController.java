package clone.example.instagram.domain.feed.controller.member;

import clone.example.instagram.domain.feed.dto.member.MemberDto;
import clone.example.instagram.domain.feed.entity.member.Member;
import clone.example.instagram.domain.feed.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MemberDto memberDto) {
        String email = memberDto.getEmail();
        String pwd = memberDto.getPwd();

        Member member = memberRepository.findByEmail(email);
        if ( member != null && passwordEncoder.matches(pwd,member.getPassword())){
            return ResponseEntity.status(HttpStatus.OK).body("/post");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("/login");
        }

    }

    @PostMapping("/joinProc")
    public ResponseEntity<String> joinProc(@RequestBody Member member){
        String rawPassword = member.getPassword();
        String encPassword = passwordEncoder.encode(rawPassword);
        member.setPwd(encPassword);
        memberRepository.save(member);
        return ResponseEntity.ok("회원가입 되었습니다.");
    }



}
