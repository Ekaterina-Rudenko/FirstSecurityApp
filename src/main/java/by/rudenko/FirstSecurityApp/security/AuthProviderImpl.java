package by.rudenko.FirstSecurityApp.security;

import by.rudenko.FirstSecurityApp.services.PersonDetailsService;
import java.util.Collections;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


//don't use it, as there are standard actions and merely use service in security config
@Component
public class AuthProviderImpl /*implements AuthenticationProvider */{

/*  private final PersonDetailsService personDetailsService;

  public AuthProviderImpl(
      PersonDetailsService personDetailsService) {
    this.personDetailsService = personDetailsService;
  }

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username = authentication.getName();
    UserDetails personDetails = personDetailsService.loadUserByUsername(username);

    String password = authentication.getCredentials().toString();
    if(!password.equals(personDetails.getPassword())){
      throw new BadCredentialsException("Incorrect Password!");
    }
    return new UsernamePasswordAuthenticationToken(personDetails, password, Collections.emptyList());
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return true;
  }*/
}
