package clone.example.instagram.domain.feed.dto.member;

import clone.example.instagram.domain.feed.entity.member.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private String email;
    private String pwd;

    public MemberDto(Member member){
        this.email = member.getEmail();
        this.pwd = member.getPwd();
    }

}
