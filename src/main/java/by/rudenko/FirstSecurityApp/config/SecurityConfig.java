package by.rudenko.FirstSecurityApp.config;

import by.rudenko.FirstSecurityApp.services.PersonDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final PersonDetailsService personDetailsService;

  public SecurityConfig(
      PersonDetailsService personDetailsService) {
    this.personDetailsService = personDetailsService;
  }

  //Configure authentication
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    /*auth.authenticationProvider(authProvider);*/
    auth.userDetailsService(personDetailsService);
  }

  @Bean
  public PasswordEncoder getPasswordEncoder(){
    return NoOpPasswordEncoder.getInstance();
  }
}
