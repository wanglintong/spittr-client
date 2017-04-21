package cn.com.zlqf.spittr.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.apache.tiles.request.servlet.ServletApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{WebMvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	@Override  
    protected Filter[] getServletFilters() {  
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();  
        characterEncodingFilter.setEncoding("UTF-8");  
        characterEncodingFilter.setForceEncoding(true);  
        return new Filter[] {characterEncodingFilter};  
    }
	
}
