package clone.example.instagram.domain.feed.config;

import clone.example.instagram.domain.feed.exception.AuthFailureHandler;
import clone.example.instagram.domain.feed.exception.AuthSuccessHandler;
import clone.example.instagram.domain.feed.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@RequiredArgsConstructor
@EnableWebSecurity // 시큐리티 필터 등록
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 페이지에 특정 권한이 있는 유저만 접근을 허용할 경우 권한 및 인증을 미리 체크하겟다는 설정을 활성화.?

@ConditionalOnDefaultWebSecurity
@ConditionalOnWebApplication(type=ConditionalOnWebApplication.Type.SERVLET)
public class SecurityConfig {

    private final MemberService memberService;
    private final AuthSuccessHandler authSuccessHandler;
    private final AuthFailureHandler authFailureHandler;

    @Bean
    public BCryptPasswordEncoder encryptPassword() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/login/**").permitAll()
                .anyRequest()
                .authenticated()
             .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/joinProc")
                .successHandler(authSuccessHandler)
                .failureHandler(authFailureHandler)
             .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/login"))
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true) // 인증정보를 지우고 세션을 무효화
                .deleteCookies("JSESSIONID") //JSESSIONID 쿠키 삭제
                .permitAll()
             .and()
                .sessionManagement()
                .maximumSessions(1) // 세션 최대 허용 수 1 / - 1이면 무제한 세션 허용의미
                .maxSessionsPreventsLogin(false) // true면 중복 로그인 막음 false면 이전 로그인 세션 해제
                .expiredUrl("/login?error=true&exception=로그인을 시도 할 수 없습니다 새로운 페이지에서 로그인을 시도해주세요. 세션이 만료되었습니다.")
             .and()
                .and().rememberMe()
                .alwaysRemember(false)
                .tokenValiditySeconds(43200) // 12시간 유지
                .rememberMeParameter("remember-me");

        return http.build();
    }
}
