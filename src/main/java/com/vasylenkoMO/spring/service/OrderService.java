package com.vasylenkoMO.spring.service;

import com.vasylenkoMO.spring.model.ProductOrder;

/**
 * Created by vastl271nko on 19.08.16.
 */
public interface OrderService {

    public void sendOrderConfirmation(ProductOrder productOrder);
}
