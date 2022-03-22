package pl.krman.list.of.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
public class ListOfMoviesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListOfMoviesApiApplication.class, args);
	}

}
