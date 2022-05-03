package org.raptor.notes.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan("org.raptor")
@EnableMongoRepositories("org.raptor")
public class NoteApplication {

    public static void main ( String ...a ) {
        SpringApplication.run(NoteApplication.class);
    }

}
