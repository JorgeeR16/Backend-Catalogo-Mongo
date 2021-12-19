package co.usa.catalogo.revista.Interfaz;

import co.usa.catalogo.revista.Modelos.User;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserCrudrepositorio extends MongoRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findTopByOrderByIdDesc();

    List<User> findByMonthBirthtDay(String monthBirthtDay);
}
