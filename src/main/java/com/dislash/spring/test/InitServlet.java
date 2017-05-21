package com.dislash.spring.test;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class InitServlet implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext container) throws ServletException {
      XmlWebApplicationContext appContext = new XmlWebApplicationContext();
      appContext.setConfigLocation("/WEB-INF/classes/spring-config.xml");

      ServletRegistration.Dynamic dispatcher = container.addServlet("DispatcherServlet", new DispatcherServlet(appContext));
      dispatcher.setLoadOnStartup(1);
      dispatcher.addMapping("/*");
    }
}