package com.ahumada.finanzaspersonales;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FinanzaspersonalesApplication}.
 */
@Generated
public class FinanzaspersonalesApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'finanzaspersonalesApplication'.
   */
  public static BeanDefinition getFinanzaspersonalesApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FinanzaspersonalesApplication.class);
    beanDefinition.setInstanceSupplier(FinanzaspersonalesApplication::new);
    return beanDefinition;
  }
}
