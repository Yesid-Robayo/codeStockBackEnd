package com.codestock.codeStockBackEnd.controller;

import com.codestock.codeStockBackEnd.methods.BuildPDFMethod;
import com.codestock.codeStockBackEnd.methods.BuildPDFMethodUserOrder;
import com.codestock.codeStockBackEnd.model.dto.*;
import com.codestock.codeStockBackEnd.model.entity.Category;
import com.codestock.codeStockBackEnd.model.entity.Price;
import com.codestock.codeStockBackEnd.model.entity.Product;
import com.codestock.codeStockBackEnd.model.entity.ProductCategory;
import com.codestock.codeStockBackEnd.service.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * This class represents the Products Controller.
 * It handles HTTP requests and responses for operations related to products.
 * It uses Spring Boot annotations for restfull web services.
 */
@RestController
@RequestMapping("/api/v1")
@Tag(name = "Products", description = "Products Controller")
public class ProductsController {
    // Service to handle operations related to products
    private final IProduct productService;
    // Service to handle operations related to prices
    private final IPrice priceService;
    // Service to handle operations related to product categories
    private final IProductCategory productCategoryService;
    // Service to handle operations related to categories
    private final ICategory categoryService;
    private final ICompany companyService;

    /**
     * Constructor for the ProductsController.
     * It uses dependency injection to get the required services.
     *
     * @param productService         The service to handle product operations.
     * @param priceService           The service to handle price operations.
     * @param productCategoryService The service to handle product category operations.
     * @param categoryService        The service to handle category operations.
     */
    @Autowired
    public ProductsController(IProduct productService, IPrice priceService, IProductCategory productCategoryService, ICategory categoryService, ICompany companyService) {

        this.categoryService = categoryService;
        this.productCategoryService = productCategoryService;
        this.productService = productService;
        this.priceService = priceService;
        this.companyService = companyService;

    }

    /**
     * Handles the GET request to retrieve products by company.
     *
     * @param id The ID of the company.
     * @return A ResponseEntity containing the list of products or an error message.
     */
    @GetMapping("/productsCompany/{id}")
    public ResponseEntity<?> getProductsByCompany(@PathVariable Integer id) {
        try {
            Iterable<Product> products = productService.findAllByIdCompany(id);

            List<ProductResponseDTO> productDTOList = new ArrayList<>();

            for (Product product : products) {
                Iterable<Price> price = priceService.findByIdProduct(product.getIdProduct());
                Iterable<ProductCategory> productCategory = productCategoryService.findByIdProduct(product.getIdProduct());
                List<CategoryDTO> categories = new ArrayList<>();
                for (ProductCategory pc : productCategory) {
                    Category category = categoryService.findByIdCategory(pc.getIdCategory());
                    categories.add(CategoryDTO.builder().idCategory(category.getIdCategory())
                            .name(category.getName())
                            .build());
                }
                List<PriceDTO> prices = new ArrayList<>();
                for (Price p : price) {
                    prices.add(PriceDTO.builder().idCurrency(p.getIdCurrency())
                            .price(p.getPrice())
                            .idProduct(p.getIdProduct())
                            .build());
                }


                productDTOList.add(ProductResponseDTO.builder().idProduct(product.getIdProduct())
                        .code(product.getCode())
                        .name(product.getName())
                        .characteristics(product.getCharacteristics())
                        .idCompany(product.getIdCompany())
                        .prices(prices)
                        .categories(categories)
                        .build());
            }
            if (productDTOList.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Products not found");
            }
            return ResponseEntity.ok(productDTOList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error getting products");
        }
    }

    /**
     * Handles the GET request to retrieve a product by its ID.
     *
     * @param id The ID of the product.
     * @return A ResponseEntity containing the product or an error message.
     */
    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id) {
        try {
            Product product = productService.findById(id);
            if (product == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
            }
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


            return ResponseEntity.ok(ProductResponseDTO.builder().idProduct(product.getIdProduct())
                    .code(product.getCode())
                    .name(product.getName())
                    .characteristics(product.getCharacteristics())
                    .idCompany(product.getIdCompany())
                    .prices(prices)
                    .categories(categories)
                    .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error getting product");
        }
    }

    /**
     * Handles the GET request to retrieve all products.
     *
     * @return A ResponseEntity containing the list of products or an error message.
     */
    @GetMapping("/products")
    public ResponseEntity<?> getProducts() {
        try {
            Iterable<Product> products = productService.findAll();
            List<ProductResponseDTO> productDTOList = new ArrayList<>();

            for (Product product : products) {
                Iterable<Price> price = priceService.findByIdProduct(product.getIdProduct());
                List<PriceDTO> prices = new ArrayList<>();
                for (Price p : price) {
                    prices.add(PriceDTO.builder().idCurrency(p.getIdCurrency())
                            .price(p.getPrice())
                            .idProduct(p.getIdProduct())
                            .build());
                }
                Iterable<ProductCategory> productCategory = productCategoryService.findByIdProduct(product.getIdProduct());
                List<CategoryDTO> categories = new ArrayList<>();
                for (ProductCategory pc : productCategory) {
                    Category category = categoryService.findByIdCategory(pc.getIdCategory());
                    categories.add(CategoryDTO.builder().idCategory(category.getIdCategory())
                            .name(category.getName())
                            .build());
                }
                productDTOList.add(ProductResponseDTO.builder().idProduct(product.getIdProduct())
                        .code(product.getCode())
                        .name(product.getName())
                        .characteristics(product.getCharacteristics())
                        .idCompany(product.getIdCompany())
                        .prices(prices)
                        .categories(categories)
                        .build());
            }
            if (productDTOList.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Products not found");
            }
            return ResponseEntity.ok(productDTOList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error getting products");
        }
    }

    /**
     * Handles the POST request to save a product.
     *
     * @param productRequestDTO The product to save.
     * @return A ResponseEntity containing the saved product or an error message.
     */
    @PostMapping("/product")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> saveProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        try {

            Product product = productService.save(
                    ProductDTO.builder().idProduct(productRequestDTO.getIdProduct())
                            .code(productRequestDTO.getCode())
                            .name(productRequestDTO.getName())
                            .characteristics(productRequestDTO.getCharacteristics())
                            .idCompany(productRequestDTO.getIdCompany())
                            .build()
            );
            List<PriceDTO> prices = productRequestDTO.getPrices();
            for (PriceDTO priceDTO : prices) {
                priceService.save(PriceDTO.builder().idCurrency(priceDTO.getIdCurrency())
                        .price(priceDTO.getPrice())
                        .idProduct(product.getIdProduct())
                        .build());
            }
            List<CategoryDTO> categories = productRequestDTO.getCategories();
            for (CategoryDTO categoryDTO : categories) {
                productCategoryService.save(ProductCategory.builder().idCategory(categoryDTO.getIdCategory())
                        .idProduct(product.getIdProduct())
                        .build());
            }
            return ResponseEntity.ok(ProductDTO.builder().idProduct(product.getIdProduct())
                    .code(product.getCode())
                    .name(product.getName())
                    .characteristics(product.getCharacteristics())
                    .idCompany(product.getIdCompany())
                    .build());


        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving product");
        }
    }

    /**
     * Handles the DELETE request to delete a product by its ID.
     *
     * @param id The ID of the product to delete.
     * @return A ResponseEntity containing a success message or an error message.
     */
    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        try {

            productCategoryService.deleteByIdProduct(id);
            priceService.deleteByIdProduct(id);

            productService.delete(id);
            return ResponseEntity.ok(Map.of("statusCode", HttpStatus.OK.value(), "message", "Product deleted successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting product");
        }
    }

    /**
     * Handles the PUT request to update a product.
     *
     * @param productRequestDTO The product to update.
     * @return A ResponseEntity containing the updated product or an error message.
     */
    @PutMapping("/product")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> updateProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        try {
            Product product = productService.save(
                    ProductDTO.builder().idProduct(productRequestDTO.getIdProduct())
                            .code(productRequestDTO.getCode())
                            .name(productRequestDTO.getName())
                            .characteristics(productRequestDTO.getCharacteristics())
                            .idCompany(productRequestDTO.getIdCompany())
                            .build()
            );
            List<PriceDTO> prices = productRequestDTO.getPrices();
            for (PriceDTO priceDTO : prices) {
                priceService.save(PriceDTO.builder().idCurrency(priceDTO.getIdCurrency())
                        .price(priceDTO.getPrice())
                        .idProduct(product.getIdProduct())
                        .build());
            }
            List<CategoryDTO> categories = productRequestDTO.getCategories();
            productCategoryService.deleteByIdProduct(product.getIdProduct());
            for (CategoryDTO categoryDTO : categories) {
                productCategoryService.save(ProductCategory.builder().idCategory(categoryDTO.getIdCategory())
                        .idProduct(product.getIdProduct())
                        .build());
            }
            return ResponseEntity.ok(ProductDTO.builder().idProduct(product.getIdProduct())
                    .code(product.getCode())
                    .name(product.getName())
                    .characteristics(product.getCharacteristics())
                    .idCompany(product.getIdCompany())
                    .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating product");
        }
    }

    /**
     * Handles the DELETE request to delete products by company.
     *
     * @param id The ID of the company.
     * @return A ResponseEntity containing a success message or an error message.
     */
    @DeleteMapping("/productsCompany/{id}")
    public ResponseEntity<?> deleteProductsByCompany(@PathVariable Integer id) {
        try {
            productService.deleteByIdCompany(id);
            return ResponseEntity.ok("Products deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting products");
        }
    }

    /**
     * Handles the POST request to send an inventory email with a PDF attachment.
     *
     * @param idCompany The ID of the company.
     * @return A ResponseEntity containing a success message or an error message.
     */
    @GetMapping("/sendInventoryEmailPDF/{idCompany}")
    public ResponseEntity<?> sendInventoryEmailPDF(@PathVariable Integer idCompany) {
        try {
            String otherApiUrl = "https://3wln6v114a.execute-api.us-east-2.amazonaws.com/sendEmailPDF";
            BuildPDFMethod buildPDFMethod = new BuildPDFMethod(companyService, productService, priceService, productCategoryService, categoryService);
            String base64Email = buildPDFMethod.generateDocumentPDF(idCompany);

            if (base64Email == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating PDF");
            }

            Map<String, Object> emailBody = Map.of(
                    "to", "yesidrobayo11@gmail.com",
                    "subject", "Inventarios de la empresa",
                    "body", "Estimado equipo,\n\nAdjunto encontrarán el inventario actualizado de la empresa. Este incluye una lista detallada de todos los productos y cualquier otra información relevante. \n\nGracias y saludos cordiales",
                    "pdf_base64", base64Email
            );


            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(emailBody, headers);
            ResponseEntity<String> responseEntity = new RestTemplate().exchange(otherApiUrl, HttpMethod.POST, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                return ResponseEntity.ok(Map.of("statusCode", HttpStatus.OK.value(), "message", "Email sent successfully"));
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending email");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending email");
        }

    }

    /**
     * Handles the POST request to send an inventory email with a PDF attachment for a user order.
     *
     * @param productResponseDTO The list of products in the order.
     * @return A ResponseEntity containing a success message or an error message.
     */
    @PostMapping("/sendInventoryEmailPDFUserOrder")
    public ResponseEntity<?> sendInventoryEmailPDFUserOrder(@RequestBody List<ProductResponseDTO> productResponseDTO) {
        try {
            String otherApiUrl = "https://3wln6v114a.execute-api.us-east-2.amazonaws.com/sendEmailPDF";
            BuildPDFMethodUserOrder buildPDFMethodUserOrder = new BuildPDFMethodUserOrder( productResponseDTO);
            String base64Email = buildPDFMethodUserOrder.generateDocumentPDF();

            if (base64Email == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating PDF");
            }

            Map<String, Object> emailBody = Map.of(
                    "to", "yesidrobayo11@gmail.com",
                    "subject", "Inventarios de tu order",
                    "body", "Estimado usuario,\n\nAdjunto encontrarán el inventario actualizado de tu order. Este incluye una lista detallada de todos los productos y cualquier otra información relevante. \n\nGracias y saludos cordiales",
                    "pdf_base64", base64Email
            );


            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(emailBody, headers);
            ResponseEntity<String> responseEntity = new RestTemplate().exchange(otherApiUrl, HttpMethod.POST, requestEntity, String.class);

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                return ResponseEntity.ok(Map.of("statusCode", HttpStatus.OK.value(), "message", "Email sent successfully"));
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending email");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending email");
        }
    }
}
