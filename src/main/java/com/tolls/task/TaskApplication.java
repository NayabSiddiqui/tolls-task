package com.tolls.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }

    @Bean
    public TollsProcessingTask tollsProcessingTask() {
        return new TollsProcessingTask();
    }

    public class TollsProcessingTask implements CommandLineRunner {

        @Override
        public void run(String... args) throws Exception {
            //parameteres stationid, license plate, timestamp

            if (args != null && args.length == 3) {
                System.out.println("parameter length is " + args.length);

                String stationId = args[0];
                String licensePlate = args[1];
                String timestamp = args[2];

                System.out.println("Station ID is " + stationId + ", plate is " + licensePlate + ", timestamp is " + timestamp);
            }

        }
    }
}
