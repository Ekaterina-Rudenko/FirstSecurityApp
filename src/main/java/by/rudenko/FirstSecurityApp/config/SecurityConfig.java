package by.rudenko.FirstSecurityApp.config;

import by.rudenko.FirstSecurityApp.services.PersonDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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

  //configure spring security itself, what page is for login, errors etc
  //configure authorization
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    //to use our page
    http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/auth/login", "/error").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin().loginPage("/auth/login")
        .loginProcessingUrl("/process_login")
        .defaultSuccessUrl("/hello", true)
        .failureUrl("/auth/login?error");
  }

  //Configure authentication
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    /*auth.authenticationProvider(authProvider);*/
    auth.userDetailsService(personDetailsService);
  }

  @Bean
  public PasswordEncoder getPasswordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }
}
