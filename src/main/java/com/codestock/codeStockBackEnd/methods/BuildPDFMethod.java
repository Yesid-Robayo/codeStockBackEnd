package com.codestock.codeStockBackEnd.methods;

import com.codestock.codeStockBackEnd.model.dto.CategoryDTO;
import com.codestock.codeStockBackEnd.model.dto.PriceDTO;
import com.codestock.codeStockBackEnd.model.dto.ProductResponseDTO;
import com.codestock.codeStockBackEnd.model.entity.*;
import com.codestock.codeStockBackEnd.service.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is responsible for building PDF documents.
 * It uses services to fetch data from the database and iText library to build the PDF.
 * The main functionality is provided by the generateDocumentPDF method.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.itextpdf.text.Document
 * @see com.itextpdf.text.pdf.PdfWriter
 */
public class BuildPDFMethod {

    private final ICompany companyService;
    private final IProduct productService;
    private final IPrice priceService;
    private final IProductCategory productCategoryService;
    private final ICategory categoryService;

    public BuildPDFMethod(ICompany companyService, IProduct productService, IPrice priceService, IProductCategory productCategoryService, ICategory categoryService) {
        this.companyService = companyService;
        this.productService = productService;
        this.priceService = priceService;
        this.productCategoryService = productCategoryService;
        this.categoryService = categoryService;
    }

    /**
     * This method generates a PDF document with the company's inventory.
     * It uses the iText library to create the PDF.
     *
     * @param idCompany The ID of the company to generate the document for.
     * @return A Base64 encoded string representing the PDF document.
     * @throws DocumentException If an error occurs during document processing.
     */
    public String generateDocumentPDF(Integer idCompany) throws  DocumentException {
        Document document;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Paragraph paragraph = new Paragraph();

        Font fontTitleMain = FontFactory.getFont(FontFactory.TIMES_ROMAN, 16);
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA, 14);
        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA, 12);
        Font fontText = FontFactory.getFont(FontFactory.HELVETICA, 8);

        document = new Document(PageSize.A4, 35, 30, 50, 50);
        PdfWriter.getInstance(document, byteArrayOutputStream);
        document.open();

        Company company = companyService.findByIdCompany(idCompany);

        paragraph.add(new Phrase("Inventarios de la empresa: " + company.getName(), fontTitleMain));
        paragraph.add(new Phrase(Chunk.NEWLINE));
        paragraph.add(new Phrase(Chunk.NEWLINE));


        paragraph.add(new Phrase("Datos de la empresa", fontTitleMain));

        paragraph.add(new Phrase(Chunk.NEWLINE));
        paragraph.add(new Phrase(Chunk.NEWLINE));

        paragraph.add(new Phrase("Nombre: " + company.getName(), fontParagraph));
        paragraph.add(new Phrase(Chunk.NEWLINE));

        paragraph.add(new Phrase("Nit: " + company.getNit(), fontParagraph));
        paragraph.add(new Phrase(Chunk.NEWLINE));

        paragraph.add(new Phrase("Dirección: " + company.getAddress(), fontParagraph));
        paragraph.add(new Phrase(Chunk.NEWLINE));

        paragraph.add(new Phrase("Teléfono: " + company.getPhone(), fontParagraph));
        paragraph.add(new Phrase(Chunk.NEWLINE));
        paragraph.add(new Phrase(Chunk.NEWLINE));

        paragraph.add(new Phrase("Productos", fontTitle));
        paragraph.add(new Phrase(Chunk.NEWLINE));
        paragraph.add(new Phrase(Chunk.NEWLINE));
        document.add(paragraph);

        PdfPTable tabla = new PdfPTable(9);
        tabla.addCell(new PdfPCell(new Phrase("idProduct", fontText)));
        tabla.addCell(new PdfPCell(new Phrase("Codigo", fontText)));
        tabla.addCell(new PdfPCell(new Phrase("Nombre", fontText)));
        tabla.addCell(new PdfPCell(new Phrase("Caracteristicas", fontText)));
        tabla.addCell(new PdfPCell(new Phrase("USD", fontText)));
        tabla.addCell(new PdfPCell(new Phrase("COP", fontText)));
        tabla.addCell(new PdfPCell(new Phrase("EUR", fontText)));
        tabla.addCell(new PdfPCell(new Phrase("BRL", fontText)));
        tabla.addCell(new PdfPCell(new Phrase("Categorias", fontText)));

        List<ProductResponseDTO> productDTOList = getProductByCompany(idCompany);

        for (ProductResponseDTO product : productDTOList) {
            PdfPCell categoriesCell = new PdfPCell();
            String categories = product.getCategories().stream()
                    .map(CategoryDTO::getName)
                    .collect(Collectors.joining(", "));
            categoriesCell.addElement(new Phrase(categories, fontText));

            tabla.addCell(new PdfPCell(new Phrase(product.getIdProduct().toString(), fontText)));
            tabla.addCell(new PdfPCell(new Phrase(product.getCode(), fontText)));
            tabla.addCell(new PdfPCell(new Phrase(product.getName(), fontText)));
            tabla.addCell(new PdfPCell(new Phrase(product.getCharacteristics(), fontText)));
            tabla.addCell(new PdfPCell(new Phrase(product.getPrices().get(0).getPrice().toString(), fontText)));
            tabla.addCell(new PdfPCell(new Phrase(product.getPrices().get(1).getPrice().toString(), fontText)));
            tabla.addCell(new PdfPCell(new Phrase(product.getPrices().get(2).getPrice().toString(), fontText)));
            tabla.addCell(new PdfPCell(new Phrase(product.getPrices().get(3).getPrice().toString(), fontText)));
            tabla.addCell(categoriesCell);
        }
        document.add(tabla);

        document.close();

        return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
    }

    /**
     * This method fetches the products of a company from the database.
     * It returns a list of ProductResponseDTO objects.
     *
     * @param idCompany The ID of the company to fetch the products for.
     * @return A list of ProductResponseDTO objects representing the products of the company.
     */
    public List<ProductResponseDTO> getProductByCompany(Integer idCompany) {
        Iterable<Product> products = productService.findAllByIdCompany(idCompany);
        List<ProductResponseDTO> productDTOList = new ArrayList<>();

        for (Product product : products) {
            Iterable<Price> prices = priceService.findByIdProduct(product.getIdProduct());
            List<PriceDTO> priceDTOList = new ArrayList<>();
            for (Price price : prices) {
                priceDTOList.add(PriceDTO.builder().idCurrency(price.getIdCurrency())
                        .price(price.getPrice())
                        .build());
            }
            Iterable<ProductCategory> productCategories = productCategoryService.findByIdProduct(product.getIdProduct());
            List<CategoryDTO> categoryDTOList = new ArrayList<>();
            for (ProductCategory productCategory : productCategories) {
                Category category = categoryService.findByIdCategory(productCategory.getIdCategory());
                categoryDTOList.add(CategoryDTO.builder()
                        .name(category.getName())
                        .build());
            }
            productDTOList.add(ProductResponseDTO.builder().idProduct(product.getIdProduct())
                    .code(product.getCode())
                    .name(product.getName())
                    .characteristics(product.getCharacteristics())
                    .idCompany(product.getIdCompany())
                    .prices(priceDTOList)
                    .categories(categoryDTOList)
                    .build());

        }
        return productDTOList;
    }
}
