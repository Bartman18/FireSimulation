package com.example.testtow;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GenerateReport {
    public static void GenerateReport(String[] args) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream("raport_z_symulacji.pdf"));
            document.open();

            // Wczytanie czcionki z obsługą polskich znaków
            BaseFont bf = BaseFont.createFont("arialuni.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            com.itextpdf.text.Font font = new com.itextpdf.text.Font(bf, 12);

            document.add(new Paragraph("Witaj, świecie! To jest PDF generowany przy użyciu Maven. Zażółć gęślą jaźń", font));

            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
