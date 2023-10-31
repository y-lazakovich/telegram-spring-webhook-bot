package io.automation.telegram.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
//wrapper to receive Beans
public class ApplicationContextProvider implements ApplicationContextAware {

  private static ApplicationContext context;

  public static ApplicationContext getContext() {
    return context;
  }

  @Override
  public void setApplicationContext(ApplicationContext context)
      throws BeansException {
    this.context = context;
  }
}
