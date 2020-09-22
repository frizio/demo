package cloud.frizio.web.demo.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

/**
 * DemoAppSecurityConfig
 */
@Configuration
@EnableWebSecurity
public class DemoAppSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    
    org.springframework.security.core.userdetails.User.UserBuilder users = User.withDefaultPasswordEncoder();
    
    auth.inMemoryAuthentication()
      .withUser(users.username("al").password("test123").roles("EMPLOYEE", "MANAGER"))
      .withUser(users.username("bob").password("test123").roles("MANAGER"))
      .withUser(users.username("admin").password("test123").roles("ADMIN"));

  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .anyRequest().authenticated()
      .and()
        .formLogin()
          .loginPage("/fancyLogin")
          .loginProcessingUrl("/authenticateTheUser")
          .permitAll()
      .and()
        .logout()
        .permitAll();
      
  }

}