package co.usa.catalogo.revista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import co.usa.catalogo.revista.Interfaz.CookwareCrudrepositorio;
import co.usa.catalogo.revista.Interfaz.UserCrudrepositorio;


@Component
@SpringBootApplication
public class RevistaApplication implements CommandLineRunner {


	@Autowired 
	private UserCrudrepositorio userCrudrepositorio;

	@Autowired 
	private CookwareCrudrepositorio cookwareCrudRepository;

	public static void main(String[] args) {
		SpringApplication.run(RevistaApplication.class, args);
	}
	@Override
	public void run (String... args) throws Exception{
		cookwareCrudRepository.deleteAll();
		userCrudrepositorio.deleteAll();
	}

}
