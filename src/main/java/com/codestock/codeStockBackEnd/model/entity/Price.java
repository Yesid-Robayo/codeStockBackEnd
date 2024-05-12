package com.codestock.codeStockBackEnd.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class represents the Price entity.
 * It implements Serializable interface for the object to be converted into a byte stream.
 * It is annotated with JPA annotations to define the table and column mappings.
 * The Lombok library annotations are used to reduce boilerplate code.
 * It captures the price details such as currency and product.
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
@Table(name = "price")
@IdClass(MyKey.class)
public class Price implements Serializable {

    /**
     * The ID of the currency.
     * It is a part of the composite key of the Price table.
     */
    @Id
    @Column(name = "idCurrency")
    private Integer idCurrency;

    /**
     * The ID of the product.
     * It is a part of the composite key of the Price table.
     */
    @Id
    @Column(name = "idProduct")
    private Integer idProduct;

    /**
     * The price of the product in the specified currency.
     */
    @Column(name = "price")
    private Double price;
}

/**
 * This class represents the composite key for the Price entity.
 * It implements Serializable interface for the object to be converted into a byte stream.
 * The Lombok library annotations are used to reduce boilerplate code.
 * It captures the currency and product details for the price.
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
class MyKey implements Serializable {

    /**
     * The ID of the currency.
     * It is a part of the composite key of the Price table.
     */
    private Integer idCurrency;

    /**
     * The ID of the product.
     * It is a part of the composite key of the Price table.
     */
    private Integer idProduct;

    /**
     * Checks if the specified object is equal to this MyKey.
     * The result is true if and only if the argument is not null and is a MyKey object that has the same idCurrency and idProduct as this object.
     *
     * @param o The object to compare this MyKey against
     * @return true if the given object represents a MyKey equivalent to this MyKey, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyKey myKey = (MyKey) o;
        return idCurrency.equals(myKey.idCurrency) && idProduct.equals(myKey.idProduct);
    }

    /**
     * Returns a hash code value for this MyKey.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idCurrency, idProduct);
    }
}