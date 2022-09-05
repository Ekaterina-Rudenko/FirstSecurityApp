package by.rudenko.FirstSecurityApp.security;

import by.rudenko.FirstSecurityApp.models.Person;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class PersonDetails implements UserDetails {
private final Person person;

  public PersonDetails(Person person) {
    this.person = person;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;//Get roles from db and collections of authorities
  }

  @Override
  public String getPassword() {
    return this.person.getPassword();
  }

  @Override
  public String getUsername() {
    return this.person.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  //In order to get authenticated user's data
  public Person getPerson(){
    return this.person;
  }
}
