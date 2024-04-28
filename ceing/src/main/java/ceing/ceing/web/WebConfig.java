package ceing.ceing.web;

import ceing.ceing.formatter.MemberFormatter;
import ceing.ceing.web.member.login.LoginAnnotationArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    /**
     * 인터셉터 등록
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/error/**");
    }

    /**
     * ArgumentResolver 등록
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginAnnotationArgumentResolver());
    }

    /**
     * 포멧터 등록
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new MemberFormatter());
    }

    /**
     * 검증용 메시지 소스 추가
     */

}
