package co.usa.catalogo.revista.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.catalogo.revista.Modelos.User;
import co.usa.catalogo.revista.Repositorio.UserRepositorio;

@Service
public class UserServicio {

    @Autowired
    private UserRepositorio userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }

    public User create(User user) {
        Optional<User> userIdMaximo = userRepository.lastUserId();
        if (user.getId() == null) {
            if (userIdMaximo.isEmpty())
                user.setId(1);
            else
                user.setId(userIdMaximo.get().getId() + 1);
        }
        Optional<User> e = userRepository.getUser(user.getId());
        if (e.isEmpty()) {
            if (existeEmail(user.getEmail()) == false) {
                return userRepository.create(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    
    public User update(User user) {
        if (user.getId() != null) {
            Optional<User> userDB = userRepository.getUser(user.getId());
            if (!userDB.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDB.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDB.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDB.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDB.get().setCellPhone(user.getCellPhone());
                }
                if (user.getCellPhone() != null) {
                    userDB.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDB.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDB.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDB.get().setZone(user.getZone());
                }
                userRepository.update(userDB.get());
                return userDB.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public boolean existeEmail(String email) {
        return userRepository.existeEmail(email);
    }

    public User authenticateUser(String email, String password) {
        Optional<User> usuario = userRepository.autenticarUsuario(email, password);
        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }

    public List<User> birthtDayList(String monthBirthtDay) {
        return userRepository.birthtDayList(monthBirthtDay);
    }
}
