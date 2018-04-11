package gif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application /*extends SpringBootServletInitializer*/ {

    /* uncomment out "extends SpringBootServletInitializer to deploy to remote server*/

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

//Comment out this override if you want to run this application locally
    /*@Override
    protected SpringApplicationBuilder configure (SpringApplicationBuilder application){
        return application.sources(Application.class);
    }*/
}
