package com.codestock.codeStockBackEnd.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

/**
 * This class represents the ProductOrder entity.
 * It implements Serializable interface for the object to be converted into a byte stream.
 * It is annotated with JPA annotations to define the table and column mappings.
 * The Lombok library annotations are used to reduce boilerplate code.
 * It captures the product and order details for the product order.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see jakarta.persistence.Entity
 * @see jakarta.persistence.Table
 * @see jakarta.persistence.Id
 * @see jakarta.persistence.Column
 * @see jakarta.persistence.GeneratedValue
 * @see jakarta.persistence.GenerationType
 * @see java.io.Serializable
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "product_order")
@IdClass(MyKeyOrderProduct.class)
public class ProductOrder {

    /**
     * The ID of the product.
     * It is a part of the composite key of the ProductOrder table.
     */
    @Id
    @Column(name = "idProduct")
    private Integer idProduct;

    /**
     * The ID of the order.
     * It is a part of the composite key of the ProductOrder table.
     */
    @Id
    @Column(name = "idOrder")
    private Integer idOrder;

    /**
     * The quantity of the product in the order.
     */
    @Column(name = "quantity")
    private Integer quantity;
}

/**
 * This class represents the composite key for the ProductOrder entity.
 * It implements Serializable interface for the object to be converted into a byte stream.
 * The Lombok library annotations are used to reduce boilerplate code.
 * It captures the product and order details for the product order.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see java.io.Serializable
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
class MyKeyOrderProduct {

    /**
     * The ID of the product.
     * It is a part of the composite key of the ProductOrder table.
     */
    private Integer idProduct;

    /**
     * The ID of the order.
     * It is a part of the composite key of the ProductOrder table.
     */
    private Integer idOrder;

    /**
     * Checks if the specified object is equal to this MyKeyOrderProduct.
     * The result is true if and only if the argument is not null and is a MyKeyOrderProduct object that has the same idProduct and idOrder as this object.
     *
     * @param o The object to compare this MyKeyOrderProduct against
     * @return true if the given object represents a MyKeyOrderProduct equivalent to this MyKeyOrderProduct, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyKeyOrderProduct myKey = (MyKeyOrderProduct) o;
        return idProduct.equals(myKey.idProduct) && idOrder.equals(myKey.idOrder);
    }

    /**
     * Returns a hash code value for this MyKeyOrderProduct.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idProduct, idOrder);
    }
}