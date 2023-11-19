package com.pdfGenerator.pdfGenerator.service;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.*;
import java.io.IOException;

public class PdfService {
    public void generatePDF(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(20);

        Paragraph paragraph = new Paragraph("PDF Generator", font);
        paragraph.setAlignment(Element.ALIGN_CENTER);

        float padding = 5f;
        int columns = 3;
        PdfPTable table = new PdfPTable(columns);
        int[] tableWidth = {33,33,33};
        table.setWidthPercentage(100f);
        table.setWidths(tableWidth);
        table.setSpacingBefore(20);

        PdfPCell cell1 = new PdfPCell();
        cell1.setPhrase(new Phrase("PDF Generator"));
        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell1.setVerticalAlignment(Element.ALIGN_CENTER);
        cell1.setBackgroundColor(Color.lightGray);
        cell1.setPadding(padding);
        cell1.setColspan(3);
        table.addCell(cell1);

        PdfPCell cell2 = new PdfPCell();
        cell2.setPhrase(new Phrase("PDF"));
        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell2.setVerticalAlignment(Element.ALIGN_CENTER);
        cell2.setPadding(padding);
        table.addCell(cell2);

        PdfPCell cell3 = new PdfPCell();
        cell3.setPhrase(new Phrase("PDF"));
        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell3.setVerticalAlignment(Element.ALIGN_CENTER);
        cell3.setPadding(padding);
        table.addCell(cell3);

        PdfPCell cell4 = new PdfPCell();
        cell4.setPhrase(new Phrase("PDF"));
        cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell4.setVerticalAlignment(Element.ALIGN_CENTER);
        cell4.setPadding(padding);
        table.addCell(cell4);


        document.add(paragraph);
        document.add(table);

        document.close();


    }
}
