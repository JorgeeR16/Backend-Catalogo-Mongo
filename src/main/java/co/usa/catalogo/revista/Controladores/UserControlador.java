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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import co.usa.catalogo.revista.Modelos.User;
import co.usa.catalogo.revista.Servicios.UserServicio;


@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserControlador {

    @GetMapping("/holamundo")
    public String saludar() {
        return "Hola Mundo, si funciona";
    }

    @Autowired
    private UserServicio userServicio;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAll() {
        return userServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional <User> getUser(@PathVariable("id") int id) {
        return userServicio.getUser(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return userServicio.create(user);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user){
        return userServicio.update(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return userServicio.delete(id);
    }


    @GetMapping("/{email}/{password}")
    public User auntenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userServicio.authenticateUser(email, password);
    }

    @GetMapping("/emailexist/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return userServicio.existeEmail(email);
    }

}
