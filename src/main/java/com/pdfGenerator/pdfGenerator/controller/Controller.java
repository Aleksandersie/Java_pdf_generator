package com.pdfGenerator.pdfGenerator.controller;

import com.pdfGenerator.pdfGenerator.service.PdfService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Controller {

    @GetMapping("/pdf")
    public void getPdf(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=file.pdf";
        response.setHeader(headerKey, headerValue);

        PdfService pdfService = new PdfService();
        pdfService.generatePDF(response);
    }
}
