package by.rudenko.FirstSecurityApp.config;

import by.rudenko.FirstSecurityApp.security.AuthProviderImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  private final AuthProviderImpl authProvider;

  public SecurityConfig(AuthProviderImpl authProvider) {
    this.authProvider = authProvider;
  }

  //Configure authentication
  protected void configure(AuthenticationManagerBuilder auth){
    auth.authenticationProvider(authProvider);
  }


}
