package com.ofoun.itexperience.resolver;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.LocaleResolver;

public class UrlLocaleResolver implements LocaleResolver {

   private static final String URL_LOCALE_ATTRIBUTE_NAME = "URL_LOCALE_ATTRIBUTE_NAME";

   @Override
   public Locale resolveLocale(HttpServletRequest request) {
       // ==> /SomeContextPath/en/...
       // ==> /SomeContextPath/fr/...
       // ==> /SomeContextPath/WEB-INF/pages/...
       String uri = request.getRequestURI();

       System.out.println("URI=" + uri);

       String prefixDe = request.getServletContext().getContextPath() + "/de/";
       String prefixFr = request.getServletContext().getContextPath() + "/fr/";
       String prefixEn = request.getServletContext().getContextPath() + "/en/";

       Locale locale = null;

       // German
       if (uri.startsWith(prefixDe)) {
           locale = Locale.GERMANY;
       }
       // French
       else if (uri.startsWith(prefixFr)) {
           locale = Locale.FRANCE;
       }
//      // English
       else if (uri.startsWith(prefixEn)) {
           locale = new Locale("en", "EN");
       }

       if (locale != null) {
           request.getSession().setAttribute(URL_LOCALE_ATTRIBUTE_NAME, locale);
       }
       if (locale == null) {
           locale = (Locale) request.getSession().getAttribute(URL_LOCALE_ATTRIBUTE_NAME);
           if (locale == null) {
               locale = Locale.GERMANY;
           }
       }
       return locale;
   }

   @Override
   public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
       // Nothing
   }

}