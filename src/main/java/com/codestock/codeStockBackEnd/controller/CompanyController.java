package com.codestock.codeStockBackEnd.controller;

import com.codestock.codeStockBackEnd.model.dto.CompanyDTO;
import com.codestock.codeStockBackEnd.model.entity.Company;
import com.codestock.codeStockBackEnd.model.entity.Product;
import com.codestock.codeStockBackEnd.service.ICompany;
import com.codestock.codeStockBackEnd.service.IPrice;
import com.codestock.codeStockBackEnd.service.IProduct;
import com.codestock.codeStockBackEnd.service.IProductCategory;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class represents the Company Controller.
 * It handles HTTP requests and responses for operations related to companies.
 * It uses Spring Boot annotations for RESTful web services.
 */
@RestController
@RequestMapping("/api/v1")
@Tag(name = "Company", description = "Company Controller")
public class CompanyController {

    private final ICompany companyService;
    private final IProduct productService;
    private final IPrice priceService;
    private final IProductCategory productCategoryService;

    /**
     * Constructor for the CompanyController.
     * It uses Spring's @Autowired annotation for dependency injection.
     *
     * @param companyService The service to handle company operations.
     * @param productService The service to handle product operations.
     */
    @Autowired
    public CompanyController(ICompany companyService, IProduct productService, IPrice priceService, IProductCategory productCategoryService) {
        this.companyService = companyService;
        this.productService = productService;
        this.priceService = priceService;
        this.productCategoryService = productCategoryService;
    }

    /**
     * Handles the GET request to retrieve all companies.
     *
     * @return A ResponseEntity containing the list of companies or an error message.
     */

    @GetMapping("/companies")
    public ResponseEntity<?> getCompanies() {
        try {
            Iterable<Company> companies = companyService.findAllCompany();
            List<CompanyDTO> companyDTOList = new ArrayList<>();


            for (Company company : companies) {
                companyDTOList.add(CompanyDTO.builder().idCompany(company.getIdCompany())
                        .nit(company.getNit())
                        .name(company.getName())
                        .address(company.getAddress())
                        .phone(company.getPhone())
                        .build());

            }
            if (companyDTOList.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Companies not found");
            }
            return ResponseEntity.ok(companyDTOList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error getting companies");
        }
    }

    /**
     * Handles the GET request to retrieve a company by its ID.
     *
     * @param id The ID of the company.
     * @return A ResponseEntity containing the company or an error message.
     */
    @GetMapping("/company/{id}")
    public ResponseEntity<?> getCompanyById(@PathVariable Integer id) {
        try {
            Company company = companyService.findByIdCompany(id);
            if (company == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company not found");
            }
            return ResponseEntity.ok(CompanyDTO.builder().idCompany(company.getIdCompany())
                    .nit(company.getNit())
                    .name(company.getName())
                    .address(company.getAddress())
                    .phone(company.getPhone())
                    .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error getting company");
        }
    }

    /**
     * Handles the POST request to create a new company.
     *
     * @param companyDTO The DTO containing the company data.
     * @return A ResponseEntity containing the created company or an error message.
     */
    @PostMapping("/company")
    public ResponseEntity<?> createCompany(@RequestBody CompanyDTO companyDTO) {
        try {
            Company company = companyService.save(companyDTO);
            return ResponseEntity.ok(CompanyDTO.builder().idCompany(company.getIdCompany())
                    .nit(company.getNit())
                    .name(company.getName())
                    .address(company.getAddress())
                    .phone(company.getPhone())
                    .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating company");
        }
    }

    /**
     * Handles the DELETE request to delete a company by its ID.
     *
     * @param id The ID of the company.
     * @return A ResponseEntity containing a success message or an error message.
     */
    @DeleteMapping("/company/{id}")
    public ResponseEntity<?> deleteCompanyById(@PathVariable Integer id) {
        try {
            Iterable<Product> products = productService.findAllByIdCompany(id);
            for (Product product : products) {
                priceService.deleteByIdProduct(product.getIdProduct());
                productCategoryService.deleteByIdProduct(product.getIdProduct());
            }
            productService.deleteByIdCompany(id);

            companyService.deleteByIdCompany(id);
            return ResponseEntity.ok(Map.of("statusCode", HttpStatus.OK.value(), "message", "Company deleted successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting company");
        }
    }

    /**
     * Handles the PUT request to update a company.
     *
     * @param companyDTO The DTO containing the updated company data.
     * @return A ResponseEntity containing the updated company or an error message.
     */
    @PutMapping("/company")
    public ResponseEntity<?> updateCompany(@RequestBody CompanyDTO companyDTO) {
        try {
            Company company = companyService.save(companyDTO);
            return ResponseEntity.ok(CompanyDTO.builder().idCompany(company.getIdCompany())
                    .nit(company.getNit())
                    .name(company.getName())
                    .address(company.getAddress())
                    .phone(company.getPhone())
                    .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating company");
        }
    }
}
