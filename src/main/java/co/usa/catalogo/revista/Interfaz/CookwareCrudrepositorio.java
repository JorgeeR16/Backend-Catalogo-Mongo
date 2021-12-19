package co.usa.catalogo.revista.Interfaz;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import co.usa.catalogo.revista.Modelos.Cookware;

public interface CookwareCrudrepositorio extends MongoRepository<Cookware, String>{

    public List<Cookware> findByPriceLessThanEqual(double precio);

    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Cookware> findByDescriptionLike(String description);

}
