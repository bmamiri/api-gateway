package springbootzuulgatwayproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import springbootzuulgatwayproxy.filters.ErrorFilter;
import springbootzuulgatwayproxy.filters.PostFilter;
import springbootzuulgatwayproxy.filters.PreFilter;
import springbootzuulgatwayproxy.filters.RouteFilter;

@SpringBootApplication
@EnableZuulProxy
public class SpringBootZuulgatwayproxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootZuulgatwayproxyApplication.class, args);
    }

    @Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }

    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }

    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }

    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }
}
