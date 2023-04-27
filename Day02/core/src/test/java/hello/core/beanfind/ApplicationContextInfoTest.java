package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
  AnnotationConfigApplicationContext ac =
      new AnnotationConfigApplicationContext(AppConfig.class);

  @Test
  @DisplayName("컨테이너에 등록된 모든 빈 출력하기")
  void findAllBeans() {
    String[] beanNames = ac.getBeanDefinitionNames();
    for (String beanName : beanNames) {
      Object bean = ac.getBean(beanName);
      System.out.println("beanname : " + beanName + ", object : " + bean);
    }
  }

  @Test
  @DisplayName("애플리케이션 빈 출력하기")
  void findApplicationBeans() {
    String[] beanNames = ac.getBeanDefinitionNames();
    for (String beanName : beanNames) {
      BeanDefinition beanDefinition = ac.getBeanDefinition(beanName);
      if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
        Object bean = ac.getBean(beanName);
        System.out.println("beanname : " + beanName + ", object : " + bean);
      }
    }
  }
}
