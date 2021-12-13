package co.usa.catalogo.revista.Repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.catalogo.revista.Interfaz.OrderCrudRepositorio;
import co.usa.catalogo.revista.Modelos.Order;

@Repository
public class OrderRepositorio {


    @Autowired
    private OrderCrudRepositorio orderCrudRepository;

    public List<Order> getAll() {
        return (List<Order>) orderCrudRepository.findAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderCrudRepository.findById(id);
    }

    public Order create(Order order) {
        return orderCrudRepository.save(order);
    }

    public void update(Order order) {
        orderCrudRepository.save(order);
    }

    public void delete(Order order) {
        orderCrudRepository.delete(order);
    }
    
    public Optional<Order> lastUserId(){
        return orderCrudRepository.findTopByOrderByIdDesc();
    }
    
}
