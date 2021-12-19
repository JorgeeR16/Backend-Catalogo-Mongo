package co.usa.catalogo.revista.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.catalogo.revista.Modelos.Cookware;
import co.usa.catalogo.revista.Repositorio.CookwareRepositorio;

@Service
public class CookwareServicio {

    @Autowired
    private CookwareRepositorio cookwareRepository;

    public List<Cookware> getAll() {
        return cookwareRepository.getAll();
    }

    public Optional<Cookware> getCookware(String referencia) {
        return cookwareRepository.getCookware(referencia);
    }

    public Cookware create(Cookware accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return cookwareRepository.create(accesory);
        }
    }

    public Cookware update(Cookware accesory) {
        if (accesory.getReference() != null) {
            Optional<Cookware> accesoryDB = cookwareRepository.getCookware(accesory.getReference());
            if (!accesoryDB.isEmpty()) {

                if (accesory.getBrand() != null) {
                    accesoryDB.get().setBrand(accesory.getBrand());
                }

                if (accesory.getCategory() != null) {
                    accesoryDB.get().setCategory(accesory.getCategory());
                }

                if (accesory.getMateriales() != null) {
                    accesoryDB.get().setMateriales(accesory.getMateriales());
                }

                if (accesory.getDimensiones() != null) {
                    accesoryDB.get().setDimensiones(accesory.getDimensiones());
                }

                if (accesory.getDescription() != null) {
                    accesoryDB.get().setDescription(accesory.getDescription());
                }

                if (accesory.getPrice() != 0.0) {
                    accesoryDB.get().setPrice(accesory.getPrice());
                }

                if (accesory.getQuantity() != 0) {
                    accesoryDB.get().setQuantity(accesory.getQuantity());
                }

                if (accesory.getPhotography() != null) {
                    accesoryDB.get().setPhotography(accesory.getPhotography());
                }

                accesoryDB.get().setAvailability(accesory.isAvailability());
                cookwareRepository.update(accesoryDB.get());
                return accesoryDB.get();

            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getCookware(reference).map(accesory -> {
            cookwareRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Cookware> gadgetsByPrice(double price) {
        return cookwareRepository.gadgetsByPrice(price);
    }

    public List<Cookware> findByDescriptionLike(String description) {
        return cookwareRepository.findByDescriptionLike(description);
    }
}
