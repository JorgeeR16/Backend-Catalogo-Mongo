package co.usa.catalogo.revista.Repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.catalogo.revista.Interfaz.UserCrudrepositorio;
import co.usa.catalogo.revista.Modelos.User;

@Repository
public class UserRepositorio {

    @Autowired
    private UserCrudrepositorio userCrudRepositorio;

    public List<User> getAll() {
        return (List<User>) userCrudRepositorio.findAll();
    }

    public Optional<User> getUser(int id) {
        return userCrudRepositorio.findById(id);
    }

    public User create(User user) {
        return userCrudRepositorio.save(user);
    }

    public void update(User user) {
        userCrudRepositorio.save(user);
    }

    public void delete(User user) {
        userCrudRepositorio.delete(user);
    }

    public boolean existeEmail(String email) {
        Optional<User> usuario = userCrudRepositorio.findByEmail(email);
        return !usuario.isEmpty();
    }

    public Optional<User> autenticarUsuario(String email, String password) {
        return userCrudRepositorio.findByEmailAndPassword(email, password);
    }

    public Optional<User> lastUserId(){
        return userCrudRepositorio.findTopByOrderByIdDesc();
    }

    public List<User> birthtDayList(String monthBirthtDay) {
        return userCrudRepositorio.findByMonthBirthtDay(monthBirthtDay);
    }

}
