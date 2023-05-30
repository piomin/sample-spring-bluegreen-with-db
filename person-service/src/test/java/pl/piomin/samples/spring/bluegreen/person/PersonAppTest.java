package pl.piomin.samples.spring.bluegreen.person;

import org.springframework.boot.SpringApplication;

public class PersonAppTest {

    public static void main(String[] args) {
        SpringApplication.from(PersonApp::main)
                .with(PostgresContainerDevMode.class)
                .run(args);
    }
}
