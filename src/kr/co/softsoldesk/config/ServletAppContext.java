package kr.co.softsoldesk.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// (servlet-context에서 <annotation-driven/>와 같음)
@Configuration
// Controller이 어노테이션이 설정되어 있는 클래스를 등록하는 어노테이션
@EnableWebMvc
// 스캔할 패키지 등록
@ComponentScan("kr.co.softsoldesk.controller")
public class ServletAppContext implements WebMvcConfigurer {
	// xml에서의 servlet-context을 자바로 구현하기 위한 클래스
	

	// controller메서드 (home())에서 반환하는 문자열 앞(경로), 뒤(확장자)에 붙을 경로를 설정
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	// 정적데이터 (이미지, 사운드, 동영상, js, css) 경로 설정
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");

	}
	
	

	
}
