package com.harishSekar;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class APPInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{APPconfig.class,JPAconfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    protected String[] getServletMappings() {
        return new String[]{"/api/*"};
    }
}
