package com.app.data;

import com.app.data.entities.Order;
import com.app.data.entities.Parcel;
import com.app.data.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run (String... args) throws Exception {
        if (isTableEmpty("Order")){
            loadUserData();
        }
        if (isTableEmpty("Parcel")){
            loadParcelAndOrderData();
        }


    }

    private void loadUserData() {
        User user1 = new User();
        user1.setUsername("admin1");
        user1.setEmail("user1@gmail.com");
        user1.setLastName("Freeman");
        user1.setFirstName("Jhon");
        user1.setType(1);
        user1.setPhone(0703322450L);
        user1.setKeycloakUserId("");
        entityManager.persist(user1);
    }

    private void loadParcelAndOrderData() {
        Parcel parcel1 = new Parcel();
        parcel1.setParcelHeight(12);
        parcel1.setParcelLength(10);
        parcel1.setParcelWeight(2);
        parcel1.setParcelWidth(5);
        entityManager.persist(parcel1);


        Order order1 = new Order();
        order1.setParcel(parcel1);
        order1.setOrderComments("Fragile");
        order1.setOrderStatus("Dispached");
        order1.setOrderDescription("No description");
        order1.setOrderDateCreated();
        entityManager.persist(order1);

    }


    private boolean isTableEmpty(String entityName) {
        Long count = (Long) entityManager.createQuery("SELECT COUNT(1) FROM " + entityName).getSingleResult();
        return count == 0;
    }




}
