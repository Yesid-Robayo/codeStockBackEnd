package com.codestock.codeStockBackEnd.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class represents the ProductCategory entity.
 * It implements Serializable interface for the object to be converted into a byte stream.
 * It is annotated with JPA annotations to define the table and column mappings.
 * The Lombok library annotations are used to reduce boilerplate code.
 * It captures the product and category details for the product category.
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
@Table(name = "product_category")
@IdClass(MyKeyProductCategory.class)
public class ProductCategory implements Serializable{

    /**
     * The ID of the category.
     * It is a part of the composite key of the ProductCategory table.
     */
    @Id
    @Column(name = "idCategory")
    private Integer idCategory;

    /**
     * The ID of the product.
     * It is a part of the composite key of the ProductCategory table.
     */
    @Id
    @Column(name = "idProduct")
    private Integer idProduct;
}

/**
 * This class represents the composite key for the ProductCategory entity.
 * It implements Serializable interface for the object to be converted into a byte stream.
 * The Lombok library annotations are used to reduce boilerplate code.
 * It captures the category and product details for the product category.
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
class MyKeyProductCategory implements Serializable {

    /**
     * The ID of the category.
     * It is a part of the composite key of the ProductCategory table.
     */
    private Integer idCategory;

    /**
     * The ID of the product.
     * It is a part of the composite key of the ProductCategory table.
     */
    private Integer idProduct;

    /**
     * Checks if the specified object is equal to this MyKeyProductCategory.
     * The result is true if and only if the argument is not null and is a MyKeyProductCategory object that has the same idCategory and idProduct as this object.
     *
     * @param o The object to compare this MyKeyProductCategory against
     * @return true if the given object represents a MyKeyProductCategory equivalent to this MyKeyProductCategory, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyKeyProductCategory myKey = (MyKeyProductCategory) o;
        return idCategory.equals(myKey.idCategory) && idProduct.equals(myKey.idProduct);
    }

    /**
     * Returns a hash code value for this MyKeyProductCategory.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idCategory, idProduct);
    }
}