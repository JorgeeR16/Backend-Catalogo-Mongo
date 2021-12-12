package co.usa.catalogo.revista.Controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import co.usa.catalogo.revista.Modelos.Cookware;
import co.usa.catalogo.revista.Servicios.CookwareServicio;


@RestController
@RequestMapping("/api/cookware")
@CrossOrigin("*")
public class CookwareControlador {

    @Autowired
    private CookwareServicio accessoryService;


    @GetMapping("/all")
    public List<Cookware> getAll() {
        return accessoryService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Cookware> getCookware(@PathVariable("reference") String reference) {
        return accessoryService.getCookware(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Cookware create(@RequestBody Cookware cookware) {
        return accessoryService.create(cookware);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cookware update(@RequestBody Cookware cookware) {
        return accessoryService.update(cookware);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference){
        return accessoryService.delete(reference);
    }

}
