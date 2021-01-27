package com.api.drinktakeaway_core_back.config;

import com.api.drinktakeaway_core_back.security.UserDetailsServiceImpl;
import com.api.drinktakeaway_core_back.security.jwt.JwtEntryPoint;
import com.api.drinktakeaway_core_back.security.jwt.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    JwtEntryPoint jwtEntryPoint;

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Bean
    JwtTokenFilter jwtTokenFilter() {
        return new JwtTokenFilter();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
    }

    /**
     * @Autowired UserDetailsServiceImpl userDetailsServiceImpl;
     * 
     * @Autowired JwtEntryPoint jwtEntryPoint;
     * 
     * 
     * @Override public void configure(HttpSecurity httpSecurity) throws Exception {
     *           httpSecurity.antMatcher("/**").authorizeRequests().antMatchers("/",
     *           "/auth", "/api/v1/utenti", "/getAuth")
     *           .permitAll().anyRequest().authenticated().and().oauth2Login(); //
     *           .and().logout().invalidateHttpSession(true).clearAuthentication(true).logoutUrl("/logout").logoutSuccessUrl("/auth").permitAll();
     *           };
     * 
     **/
    /**
     * @Override protected void configure(HttpSecurity http) throws Exception {
     *           http.cors().and().csrf().disable() .authorizeRequests(a ->
     *           a.antMatchers("/", "/oauth/**", "/api/v1/utenti",
     *           "/getAuth").permitAll() .anyRequest().authenticated())
     *           .exceptionHandling(e -> e.authenticationEntryPoint(new
     *           HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))) .oauth2Login(); //
     *           .and().logout().logoutUrl("/logout").logoutSuccessUrl("/auth").permitAll();
     *           ;
     * 
     *           }
     **/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers("/api/v1/core/get_all_locals", "/api/v1/core/get_drink_quantity_to_do/**",
                        "/api/v1/core/get_drink_quantity_to_do", "/api/v1/core/get_drink_by_order_number")
                .permitAll().anyRequest().authenticated().and().exceptionHandling()
                .authenticationEntryPoint(jwtEntryPoint).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}
