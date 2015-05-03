package za.ac.cput.kristen.timetable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Hello world!
 *
 */

@Configuration
@ComponentScan
@EnableWebMvc
@EnableAutoConfiguration
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!\nThis is your timetable!" );
        SpringApplication.run(App.class, args);
    }
}
