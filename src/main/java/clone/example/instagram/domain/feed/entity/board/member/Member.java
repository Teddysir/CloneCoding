package clone.example.instagram.domain.feed.entity.board.member;

import clone.example.instagram.domain.feed.entity.BaseTimeEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@EqualsAndHashCode(of={"id"})
@NoArgsConstructor
@Getter
@Entity
public class Member extends BaseTimeEntity implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String pwd;
    private LocalDateTime lastLoginTime;

    @Builder
    public Member(Long id,String email,String pwd, LocalDateTime lastLoginTime){
        super();
        this.id = id;
        this.email = email;
        this.pwd = pwd;
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String getPassword() {
        return this.getPwd();
    }

    @Override
    public String getUsername() {
        return this.getEmail();
    }

    //계정이 갖고있는 권한 목록은 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collectors = new ArrayList<>();
        collectors.add(()->{
            return "계정별 등록할 권한";
        });

        return collectors;
    }

    // 계정이 만료되지 않았는지 리턴 (true = 만료 안됨)
    @Override
    public boolean isAccountNonExpired() {return true;}

    // 계정이 잠기지 않았는지 리턴(true = 잠기지 않음)
    @Override
    public boolean isAccountNonLocked() {return true;}

    // 계정 비밀번호가 만료되지 않았는지 리턴 (true = 만료 안됨)
    @Override
    public boolean isCredentialsNonExpired() {return true;}

    // 계정이 활성화인지 리턴(true = 활성화)
    @Override
    public boolean isEnabled() {return true;}
}
