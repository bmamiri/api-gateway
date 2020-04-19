package springbootzuulgatwayproxystudentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@SpringBootApplication
public class SpringBootZuulgatwayproxyStudentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootZuulgatwayproxyStudentServiceApplication.class, args);
    }

    @GetMapping(value = "/echoStudentName/{name}")
    public String echoStudentName(@PathVariable(name = "name") String name) {
        return "Hello " + name + " Responded on : " + new Date();
    }

    @GetMapping(value = "/getStudentDetails/{name}")
    public Student getStudentDetails(@PathVariable(name = "name") String name) {
        return new Student(name, "-", "MCA");
    }
}
