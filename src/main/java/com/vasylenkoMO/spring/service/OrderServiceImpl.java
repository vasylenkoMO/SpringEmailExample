package com.vasylenkoMO.spring.service;

import com.vasylenkoMO.spring.model.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vastl271nko on 19.08.16.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    MailService mailService;
    @Override
    public void sendOrderConfirmation(ProductOrder productOrder) {
        mailService.sendEmail(productOrder);
    }
}
