package com.ofoun.itexperience.config;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

//   @Bean(name = "messageSource")
//   public MessageSource getMessageResource() {
//       ReloadableResourceBundleMessageSource messageResource = new ReloadableResourceBundleMessageSource();
//
//       // Read i18n/messages_xxx.properties file.
//       // For example: i18n/messages_en.properties
//       messageResource.setBasename("classpath:i18n/messages");
//       messageResource.setDefaultEncoding("UTF-8");
//       return messageResource;
//   }
//
//   // To solver URL like:
//   // /SomeContextPath/en/login2
//   // /SomeContextPath/de/login2
//   // /SomeContextPath/fr/login2
//   @Bean(name = "localeResolver")
//   public LocaleResolver getLocaleResolver() {
//       LocaleResolver resolver = new UrlLocaleResolver();
//       return resolver;
//   }
//
//   //ajouté
//   @Bean
//   public LocaleResolver localeResolver() {
//       CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
//       return cookieLocaleResolver;
//   }
//   
//   @Override
//   public void addInterceptors(InterceptorRegistry registry) {
//
//       UrlLocaleInterceptor localeInterceptor = new UrlLocaleInterceptor();
////       localeInterceptor.setParamName("locale"); //ajouté
//       registry.addInterceptor(localeInterceptor).addPathPatterns("/de/*", "/fr/*", "/en/*");
//   }
//   
//   
//   //ajouté
//   @Bean
//   public LocaleChangeInterceptor localeChangeInterceptor() {
//      LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
//      localeChangeInterceptor.setParamName("locale");
//      return localeChangeInterceptor;
//   }
//   

	
	
	@Bean(name = "localeResolver")
   public LocaleResolver getLocaleResolver()  {
       CookieLocaleResolver resolver= new CookieLocaleResolver();
       resolver.setCookieDomain("myAppLocaleCookie");
       resolver.setCookieMaxAge(600); 
       return resolver;
   } 

   @Bean(name = "messageSource")
   public MessageSource messageSource()  {
       ReloadableResourceBundleMessageSource messageResource= new ReloadableResourceBundleMessageSource();         
       // For example: i18n/messages_en.properties
       // For example: i18n/messages_fr.properties
       messageResource.setBasename("classpath:langues/messages");
       messageResource.setDefaultEncoding("UTF-8");
       return messageResource;
   }
   @Override
   public void addInterceptors(InterceptorRegistry registry) {
       LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
       localeInterceptor.setParamName("lang");
       registry.addInterceptor(localeInterceptor).addPathPatterns("/*");
   }
	
	
}