package com.vasylenkoMO.spring.service;

import com.vasylenkoMO.spring.model.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by vastl271nko on 19.08.16.
 */
@Service("mailService")
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender mailSender;


    @Override
    public void sendEmail(Object object) {
        ProductOrder productOrder = (ProductOrder) object;

        MimeMessagePreparator preparator = getMessagePreparator(productOrder);

        try {
            mailSender.send(preparator);
            System.out.println("Message Send...Hurrey");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private MimeMessagePreparator getMessagePreparator(final ProductOrder order) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setFrom("pinguinnn007@gmail.com");
                mimeMessage.setRecipient(Message.RecipientType.TO,
                        new InternetAddress(order.getCustomerInfo().getEmail()));
                mimeMessage.setText("Dear " + order.getCustomerInfo().getName()
                        + ", thank you for placing order. Your order id is " + order.getOrderId() + ".");
                mimeMessage.setSubject("Your order on Demoapp");
            }
        };
        return preparator;
    }
}
