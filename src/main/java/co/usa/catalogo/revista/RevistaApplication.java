package co.usa.catalogo.revista;

import java.text.SimpleDateFormat;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import co.usa.catalogo.revista.Modelos.User;
import co.usa.catalogo.revista.Interfaz.CookwareCrudrepositorio;
import co.usa.catalogo.revista.Interfaz.OrderCrudRepositorio;
import co.usa.catalogo.revista.Interfaz.UserCrudrepositorio;
import co.usa.catalogo.revista.Modelos.Cookware;
import co.usa.catalogo.revista.Modelos.Order;
import co.usa.catalogo.revista.Modelos.User;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		// Recuperar vendedores
		Optional<User> salesManOne = userCrudRepository.findById(3);
		Optional<User> salesManTwo = userCrudRepository.findById(6);

		// Mapa de productos asociados a una orden
		Map<String, Cookware> productOrderOne = new HashMap<String, Cookware>();
		Map<String, Cookware> productOrderTwo = new HashMap<String, Cookware>();

		// Mapa de cantidades de producto asociados a una orden
		Map<String, Integer> quantitiesOrderOne = new HashMap<String, Integer>();
		Map<String, Integer> quantitiesOrderTwo = new HashMap<String, Integer>();
	}
}
