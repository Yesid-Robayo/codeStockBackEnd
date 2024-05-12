package com.codestock.codeStockBackEnd.controller;

import com.codestock.codeStockBackEnd.model.dto.*;
import com.codestock.codeStockBackEnd.model.entity.*;
import com.codestock.codeStockBackEnd.service.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
/**
 * This class represents the Order Controller.
 * It handles HTTP requests and responses for operations related to orders.
 * It uses Spring Boot annotations for RESTful web services.
 */

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Order", description = "The Order API")
public class OrderController {

    private final IProductOrder productOrderService;
    private final IOrder orderService;
    private final IProduct productService;
    private final IPrice priceService;
    private final IProductCategory productCategoryService;
    private final ICategory categoryService;

    /**
     * Constructor for the OrderController.
     * It uses dependency injection to get the required services.
     *
     * @param productOrderService The service to handle product order operations.
     * @param orderService The service to handle order operations.
     * @param productService The service to handle product operations.
     * @param priceService The service to handle price operations.
     * @param productCategoryService The service to handle product category operations.
     * @param categoryService The service to handle category operations.
     */
    public OrderController(IProductOrder productOrderService, IOrder orderService, IProduct productService, IPrice priceService, IProductCategory productCategoryService, ICategory categoryService) {
        this.productOrderService = productOrderService;
        this.orderService = orderService;
        this.productService = productService;
        this.priceService = priceService;
        this.productCategoryService = productCategoryService;
        this.categoryService = categoryService;

    }

    /**
     * Handles the POST request to save an order.
     *
     * @param orderRequestDTO The OrderRequestDTO object that contains the data to be saved.
     * @return A ResponseEntity containing a success message or an error message.
     */
    @PostMapping("/order")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> saveOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        try {

            Order orderSave = orderService.save(Order.builder().idClient(orderRequestDTO.getIdClient())
                    .date(orderRequestDTO.getDate())
                    .build());
            for (OrderProductRequestDTO productOrder : orderRequestDTO.getProducts()) {
                productOrderService.save(ProductOrder.builder().idOrder(orderSave.getIdOrder())
                        .idProduct(productOrder.getIdProduct())
                        .quantity(productOrder.getQuantity())
                        .build());

            }

            return ResponseEntity.ok("Order saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving order");
        }
    }

    /**
     * Handles the DELETE request to delete an order by its ID.
     *
     * @param id The ID of the order to be deleted.
     * @return A ResponseEntity containing a success message or an error message.
     */
    @DeleteMapping("/order/{id}")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> deleteOrder(@PathVariable Integer id) {
        try {
            productOrderService.deleteByIdOrder(id);
            orderService.deleteById(id);
            return ResponseEntity.ok("Order deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting order");
        }
    }

    /**
     * Handles the GET request to get an order by its ID.
     *
     * @param id The ID of the order to be found.
     * @return A ResponseEntity containing the found order or an error message.
     */
    @GetMapping("/order/{id}")
    public ResponseEntity<?> getOrderByIdWhitProduct(@PathVariable Integer id) {
        try {
            Order order = orderService.findById(id);
            if (order == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
            }

            Iterable<ProductOrder> productOrderList = productOrderService.findByIdOrder(id);
            List<ProductResponseDTO> productOrderResponseDTOList = new ArrayList<>();

            forProduct(productOrderList, productOrderResponseDTOList);

            return ResponseEntity.ok(productOrderResponseDTOList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error getting order");
        }
    }

    /**
     * Handles the GET request to get all orders.
     *
     * @return A ResponseEntity containing a list of orders or an error message.
     */
    private void forProduct(Iterable<ProductOrder> productOrderList, List<ProductResponseDTO> productOrderResponseDTOList) {
        for (ProductOrder productOrder : productOrderList) {
            Product product = productService.findById(productOrder.getIdProduct());
            if (product != null) {
                Iterable<Price> price = priceService.findByIdProduct(product.getIdProduct());
                List<PriceDTO> prices = new ArrayList<>();
                Iterable<ProductCategory> productCategory = productCategoryService.findByIdProduct(product.getIdProduct());
                List<CategoryDTO> categories = new ArrayList<>();
                for (ProductCategory pc : productCategory) {
                    Category category = categoryService.findByIdCategory(pc.getIdCategory());
                    categories.add(CategoryDTO.builder().idCategory(category.getIdCategory())
                            .name(category.getName())
                            .build());
                }
                for (Price p : price) {
                    prices.add(PriceDTO.builder().idCurrency(p.getIdCurrency())
                            .price(p.getPrice())
                            .idProduct(p.getIdProduct())
                            .build());
                }
                productOrderResponseDTOList.add(ProductResponseDTO.builder()
                        .idProduct(product.getIdProduct())
                        .code(product.getCode())
                        .name(product.getName())
                        .characteristics(product.getCharacteristics())
                        .idCompany(product.getIdCompany())
                        .prices(prices)
                        .categories(categories)
                        .build());
            }
        }
    }

    /**
     * Handles the GET request to get all orders.
     *
     * @return A ResponseEntity containing a list of orders or an error message.
     */
    @GetMapping("/order/client/{id}")
    public ResponseEntity<?> getOrderByClient(@PathVariable Integer id) {
        try {
            Iterable<Order> orders = orderService.findAllByIdClient(id);
            List<OrderResponseDTO> orderResponseDTOList = new ArrayList<>();

            for (Order order : orders) {
                List<ProductResponseDTO> productOrderResponseDTOList = new ArrayList<>();
                Iterable<ProductOrder> productOrderList = productOrderService.findByIdOrder(order.getIdOrder());

                forProduct(productOrderList, productOrderResponseDTOList);

                orderResponseDTOList.add(OrderResponseDTO.builder()
                        .idOrder(order.getIdOrder())
                        .idClient(order.getIdClient())
                        .date(order.getDate())
                        .products(productOrderResponseDTOList)
                        .build());
            }
            return ResponseEntity.ok(orderResponseDTOList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error getting orders");
        }
    }

}

