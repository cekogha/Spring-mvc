package fr.cekogha.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry)
	{
		// If you add the .html, it gonna find the view in the static folder
		// So you have to remove it
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/logout").setViewName("logout");
	}
}
