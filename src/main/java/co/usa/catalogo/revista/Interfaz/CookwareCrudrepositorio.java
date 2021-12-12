package co.usa.catalogo.revista.Interfaz;

import org.springframework.data.mongodb.repository.MongoRepository;
import co.usa.catalogo.revista.Modelos.Cookware;

public interface CookwareCrudrepositorio extends MongoRepository<Cookware, String>{

}
