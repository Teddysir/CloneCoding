package clone.example.instagram.domain.feed.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

// json형식으로 응답을 반환하기 위한 설정
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    MappingJackson2JsonView jsonView() {
        return new MappingJackson2JsonView();
    }

}
