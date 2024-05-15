package com.codestock.codeStockBackEnd.methods;
import com.codestock.codeStockBackEnd.model.dto.CategoryDTO;
import com.codestock.codeStockBackEnd.model.dto.ProductResponseDTO;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

public class BuildPDFMethodUserOrder {
    private final List<ProductResponseDTO> productDTOList;

    public BuildPDFMethodUserOrder( List<ProductResponseDTO> productDTOList) {
        this.productDTOList = productDTOList;
    }

    /**
     * This method generates a PDF document with the company's inventory.
     * It uses the iText library to create the PDF.
     *
     * @return A Base64 encoded string representing the PDF document.
     * @throws DocumentException If an error occurs during document processing.
     */
    public String generateDocumentPDF() throws  DocumentException {
        Document document;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Paragraph paragraph = new Paragraph();

        Font fontTitleMain = FontFactory.getFont(FontFactory.TIMES_ROMAN, 16);
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA, 14);
        Font fontText = FontFactory.getFont(FontFactory.HELVETICA, 8);

        document = new Document(PageSize.A4, 35, 30, 50, 50);
        PdfWriter.getInstance(document, byteArrayOutputStream);
        document.open();


        paragraph.add(new Phrase("Inventarios de tu order", fontTitleMain));
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


}
