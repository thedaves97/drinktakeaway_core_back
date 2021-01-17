package com.api.drinktakeaway_core_back.repository.DTA;

import com.api.drinktakeaway_core_back.dto.OrderDrinkQuantity;
import com.api.drinktakeaway_core_back.entity.DTA.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("Select o from Order o where o.email = :email order by o.timestamp desc")
    List<Order> findOrderByEmail(@Param("email") String email);

    @Query("Select max(number) from Order o")
    int findMaxOrder();

    @Query("Select Sum(o.numerosity) from Order o where o.id_locale = :idLocale")
    int getOrderDrinkQuantity(@Param("idLocale") int idLocale);

    @Query("Select new com.api.drinktakeaway_core_back.dto.OrderDrinkQuantity(Sum(o.numerosity), o.id_locale) from Order o group by o.id_locale")
    List<OrderDrinkQuantity> getOrderDrinkQuantity();

    @Query("Select o from Order o where o.menu.locale.name = :nameLocale order by o.number desc")
    List<Order> findOrdersByNameLocale(@Param("nameLocale") String nameLocale);

    @Modifying
    @Query("Update Order o set o.status=:status where o.number = :orderNumber")
    void updateOrderStatus(@Param("status") String status, @Param("orderNumber") int orderNumber);

    @Query("Select o from Order o where o.number = :number")
    List<Order> findDrinksByNumberOrder(@Param("number") int number);

}
