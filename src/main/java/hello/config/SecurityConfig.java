package hello.config;

/**
 * File comments...
 *
 * @author Kenny Fang
 * @version 1.0
 * @date 2017/12/14 15:35
 */
        import org.springframework.context.annotation.Configuration;
        import org.springframework.security.config.annotation.authentication.
        builders.AuthenticationManagerBuilder;
        import org.springframework.security.config.annotation.web.
        builders.HttpSecurity;
        import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
        import org.springframework.security.config.annotation.web.
        configuration.WebSecurityConfigurerAdapter;
        import org.springframework.security.core.userdetails.UserDetails;
        import org.springframework.security.core.userdetails.UserDetailsService;
        import org.springframework.security.core.userdetails.UsernameNotFoundException;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
//                .antMatchers("/").access("hasRole('READER')")
                .antMatchers("/mgmt/**").access("hasRole('ADMIN')")
                .antMatchers("/**").permitAll();/*.and().formLogin().and().httpBasic();*/
//        http.csrf().disable();
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .failureUrl("/login?error=true");
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(new UserDetailsService() {
//                    @Override
//                    public UserDetails loadUserByUsername(String username)
//                            throws UsernameNotFoundException {
//                        return new Reader();
//                    }
//                });
        auth
                .inMemoryAuthentication()
                    .withUser("admin").password("s3cr3t")
                .roles("ADMIN", "READER");
    }
}
