package co.usa.catalogo.revista.Repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.catalogo.revista.Interfaz.CookwareCrudrepositorio;
import co.usa.catalogo.revista.Modelos.Cookware;

@Repository
public class CookwareRepositorio {
    @Autowired
    private CookwareCrudrepositorio cookwareCrudRepositorio;

    public List<Cookware> getAll() {
        return cookwareCrudRepositorio.findAll();
    }

    public Optional<Cookware> getCookware(String referencia){
        return cookwareCrudRepositorio.findById(referencia);
    }

    public void update(Cookware cookware) {
        cookwareCrudRepositorio.save(cookware);
    }

    public Cookware create(Cookware cookware) {
        return cookwareCrudRepositorio.save(cookware);
    }

    public void delete(Cookware cookware) {
        cookwareCrudRepositorio.delete(cookware);
    }

    public List<Cookware> gadgetsByPrice(double precio) {
        return cookwareCrudRepositorio.findByPriceLessThanEqual(precio);
    }

    public List<Cookware> findByDescriptionLike(String description) {
        return cookwareCrudRepositorio.findByDescriptionLike(description);
    }

}
