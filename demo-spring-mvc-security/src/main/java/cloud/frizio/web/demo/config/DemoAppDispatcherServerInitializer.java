package cloud.frizio.web.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DemoAppDispatcherServerInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[] { DemoAppConfig.class };
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }

}
