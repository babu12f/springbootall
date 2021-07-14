package com.babor.springbootall;

import com.babor.springbootall.models.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class SpringbootallApplication {
	/**
	 * Command line runner code commented
	 *
	private static final Logger LOG = LoggerFactory.getLogger(SpringbootallApplication.class);

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			LOG.info("Starting Command Line Runner Application");

			ResponseEntity<List<Room>> rooms = restTemplate.exchange("http://localhost:8080/api/rooms"
					, HttpMethod.GET, null, new ParameterizedTypeReference<List<Room>>() {
					});

			rooms.getBody().forEach(room -> {
				LOG.info(room.toString());
			});

			LOG.info("Ending Command Line Runner Application");
		};
	}

	@Bean
    public CommandLineRunner fizzBuzzRunner() {
	    return args -> {
            LOG.info("Starting Command Line Runner ==> FIZZ BUZZ Application");

            IntStream.range(1, 100).forEach(number -> {
                if (number % 3 == 0 && number % 5 == 0) {
                    LOG.info("FizzBuzz");
                }
                else if (number % 3 == 0) {
                    LOG.info("Fizz");
                }
                else if (number % 5 == 0) {
                    LOG.info("Buzz");
                }
                else {
                    LOG.info(String.valueOf(number));
                }
            });

            LOG.info("Ending Command Line Runner ==> FIZZ BUZZ Application");
        };
    }*/

	public static void main(String[] args) {
		SpringApplication.run(SpringbootallApplication.class, args);
	}

}
