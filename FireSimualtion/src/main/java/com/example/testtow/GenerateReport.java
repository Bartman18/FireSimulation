package com.example.testtow;

import com.example.testtow.Fire.FireControl;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class GenerateReport {
    public static void GenerateReport(String[] args) {
        Document document = new Document();
        FireControl fireControl = new FireControl();

        System.out.println( fireControl.getAdditionalFire0().getHeight());
        fireControl.getAdditionalFire0().getHeight();

        try {
            PdfWriter.getInstance(document, new FileOutputStream("raport_z_symulacji.pdf"));
            document.open();

            // Wczytanie czcionki z obsługą polskich znaków
            BaseFont bf = BaseFont.createFont("arialuni.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            com.itextpdf.text.Font font = new com.itextpdf.text.Font(bf, 12);

            document.add(new Paragraph("TESTWitaj, świecie! To jest PDF generowany przy użyciu Maven. Zażółć gęślą jaźń", font));

            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File pdfFile = new File("raport_z_symulacji.pdf");

        try {
            Desktop.getDesktop().open(pdfFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
