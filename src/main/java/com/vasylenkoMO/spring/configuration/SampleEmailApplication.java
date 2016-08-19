package com.vasylenkoMO.spring.configuration;

import com.vasylenkoMO.spring.model.CustomerInfo;
import com.vasylenkoMO.spring.model.ProductOrder;
import com.vasylenkoMO.spring.service.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by vastl271nko on 19.08.16.
 */
public class SampleEmailApplication {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService = (OrderService) context.getBean("orderService");
        orderService.sendOrderConfirmation(getNewOrder());
        ((AbstractApplicationContext) context).close();
    }

    public static ProductOrder getNewOrder() {
        ProductOrder order = new ProductOrder();
        order.setOrderId("1234");
        order.setProductName("Lenovo z510");
        order.setStatus("confirmed");

        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setName("Maksym Vasylenko");
        customerInfo.setAddress("Golovatogo");
        customerInfo.setEmail("vasyl2.71nko@gmail.com");
        order.setCustomerInfo(customerInfo);
        return order;
    }
}
