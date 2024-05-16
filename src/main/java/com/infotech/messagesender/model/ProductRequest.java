package com.infotech.messagesender.model;

import com.infotech.messagesender.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductRequest {

    private String name;
    private Integer quantity;
    private PaymentMethod paymentMethod;

}
