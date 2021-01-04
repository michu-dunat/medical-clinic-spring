package com.company;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    //Do sprawdzenia
    @Autowired
    MyUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        System.out.println("\nXD\n");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        System.out.println(http);

        http.authorizeRequests()
                .antMatchers("/admin").hasRole("postgres")
                .antMatchers("/user").hasAnyRole("ClinicWorker", "Patient", "Admin")
                .antMatchers("/").permitAll()
                .and().formLogin();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        System.out.println("\n XDDD \n");
        return NoOpPasswordEncoder.getInstance(); }
}
