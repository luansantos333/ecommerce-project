package com.projetoloja.lojavirtual.service;

import com.projetoloja.lojavirtual.dto.OrderDTO;
import com.projetoloja.lojavirtual.dto.OrderItemDTO;
import com.projetoloja.lojavirtual.model.Order;
import com.projetoloja.lojavirtual.model.OrderItem;
import com.projetoloja.lojavirtual.model.OrderStatus;
import com.projetoloja.lojavirtual.model.Product;
import com.projetoloja.lojavirtual.repository.OrderRepository;
import com.projetoloja.lojavirtual.repository.ProductRepository;
import com.projetoloja.lojavirtual.repository.OrderItemRepository;
import com.projetoloja.lojavirtual.service.exceptions.ElementNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderService(OrderRepository orderRepository, UserService userService, ProductRepository productRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.productRepository = productRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) throws ElementNotFoundException {

        Optional<Order> result = orderRepository.findById(id);
        Order o = result.orElseThrow(() -> new ElementNotFoundException("Recurso não encontrado"));
        return new OrderDTO(o);
    }


    @Transactional
    public OrderDTO insertOrder(OrderDTO dto) {

        Order entity = new Order();
        copyOrderDTOToEntity(entity, dto);
        Order order = orderRepository.save(entity);
        orderItemRepository.saveAll(order.getOrderItemSet());


        return new OrderDTO(order);
    }



    private void copyOrderDTOToEntity(Order entity, OrderDTO o) {

        entity.setMoment(Instant.now());
        entity.setOrderStatus(OrderStatus.WAITING_PAYMENT);
        entity.setClient(userService.authenticated());

        for (OrderItemDTO dto : o.getItens()) {

            Product p = productRepository.getReferenceById(dto.getProductId());
            OrderItem itemdoPedido = new OrderItem(entity, p, dto.getQuantity(), p.getPrice());
            entity.getOrderItemSet().add(itemdoPedido);

        }



    }


}
