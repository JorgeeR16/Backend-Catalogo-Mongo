package co.usa.catalogo.revista;

import java.text.SimpleDateFormat;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import co.usa.catalogo.revista.Interfaz.CookwareCrudrepositorio;
import co.usa.catalogo.revista.Interfaz.OrderCrudRepositorio;
import co.usa.catalogo.revista.Interfaz.UserCrudrepositorio;

import co.usa.catalogo.revista.Modelos.Order;


import java.time.format.DateTimeFormatter;

import java.util.List;

@Component
@SpringBootApplication
public class RevistaApplication implements CommandLineRunner {

	@Autowired
	private CookwareCrudrepositorio crudRepository;
	@Autowired
	private UserCrudrepositorio userCrudRepository;
	@Autowired
	private OrderCrudRepositorio orderCrudRepository;

	public static void main(String[] args) {
		SpringApplication.run(RevistaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		crudRepository.deleteAll();
		userCrudRepository.deleteAll();
		orderCrudRepository.deleteAll();

		crudRepository.saveAll(List.of());

		userCrudRepository.saveAll(List.of());

		// Instanciar las ordenes
		Order orderOne = new Order();
		orderOne.setId(1);
		Order orderTwo = new Order();
		orderTwo.setId(2);


	}
}
