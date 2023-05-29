package com.example.testtow;

import com.example.testtow.Fire.FireControl;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.Paragraph;
import static com.itextpdf.text.pdf.PdfPCell.NO_BORDER;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.example.testtow.HelloApplication;




import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class GenerateReport {
    public static void GenerateReport(String[] args) {
        Document document = new Document();

        FireControl fireControl = new FireControl();
        double size[] = new double[4];
        size[0] = fireControl.getFire0().getHeight();
        double surface[]= new double[4];
        surface[0] = size[0]*size[0];
        size[1] = fireControl.getFire1().getHeight();
        surface[1] = size[1]*size[1];
        size[2] = fireControl.getFire2().getHeight();
        surface[2] = size[2]*size[2];
        size[3] = fireControl.getFire1().getHeight();
        surface[3] = size[3]*size[3];
        double sizead[] = new double[4];
        sizead[0] = fireControl.getAdditionalFire0().getHeight();
        double surfacead[] = new double[4];
        surfacead[0] = sizead[0]*sizead[0];
        sizead[1] = fireControl.getAdditionalFire1().getHeight();
        surfacead[1] = sizead[1]*sizead[1];
        sizead[2] = fireControl.getAdditionalFire2().getHeight();
        surfacead[2] = sizead[2]*sizead[2];
        sizead[3] = fireControl.getAdditionalFire3().getHeight();
        surfacead[3] = sizead[3]*sizead[3];
        HelloApplication helloApp = new HelloApplication();
        boolean booleanadditional[] = new boolean[4];
        booleanadditional[0] = helloApp.getIsUsed0();
        booleanadditional[1] = helloApp.getIsUsed1();
        booleanadditional[2] = helloApp.getIsUsed2();
        booleanadditional[3] = helloApp.getIsUsed3();

        double maxValueAdFire = 0;
        for (int i = 0; i < 4; i++) {
            if (booleanadditional[i]) { // Sprawdzenie parametru
                maxValueAdFire = Math.max(maxValueAdFire, sizead[i]);
            }
        }
        double maxValueFire = 0;
        for (int i = 0; i < 4; i++) {
                maxValueFire = Math.max(maxValueFire, size[i]);
        }
        double maxValueFireAll = 0;
        if(maxValueFire>maxValueAdFire)
        {
            maxValueFireAll=maxValueFire;
        }
        else
        {
            maxValueFireAll=maxValueAdFire;
        }
        double minValueAdFire = 0;
        for (int i = 0; i < 4; i++) {
            if (booleanadditional[i]) { // Sprawdzenie parametru
                minValueAdFire = Math.min(minValueAdFire, sizead[i]);
            }
        }
        double minValueFire = 0;
        for (int i = 0; i < 4; i++) {
            minValueFire = Math.min(minValueFire, size[i]);
        }
        double minValueFireAll = 0;
        if(maxValueFire>maxValueAdFire)
        {
            minValueFireAll=minValueAdFire;
        }
        else
        {
            minValueFireAll=minValueFire;
        }
        String maxValueFireAllStr = Double.toString(maxValueFireAll);
        String minValueFireAllStr = Double.toString(minValueFireAll);

        try {
            PdfWriter.getInstance(document, new FileOutputStream("raport_z_symulacji.pdf"));
            document.setMargins(50, 50, 50, 50);
            document.open();

            BaseFont baseFont = BaseFont.createFont("arialuni.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            com.itextpdf.text.Font font = new com.itextpdf.text.Font(baseFont);

            // Nagłówek - Raport z przeprowadzonej symulacji
            Font boldFont = new Font(baseFont, 12, Font.BOLD, BaseColor.BLACK);
            Font headerFont = new Font(baseFont, 16, Font.BOLD, BaseColor.BLACK);
            Paragraph headerParagraph = new Paragraph("Raport z przeprowadzonej symulacji", headerFont);
            headerParagraph.setAlignment(Element.ALIGN_CENTER);
            headerParagraph.setSpacingAfter(25); // Ustawienie odstępu po tekście
            document.add(headerParagraph);

            // Pozioma kreska
            LineSeparator lineSeparator = new LineSeparator();
            lineSeparator.setPercentage(90f);
            document.add(lineSeparator);

            // Tekst - Zawartość raportu
            Paragraph contentParagraph1 = new Paragraph("Największy pożar (powierzchnia): ", font);
            Phrase valuePhrase1 = new Phrase(maxValueFireAllStr, boldFont);
            contentParagraph1.add(valuePhrase1);
            contentParagraph1.setSpacingBefore(20); // Ustawienie odstępu po tekście
            contentParagraph1.setIndentationLeft(40);
            contentParagraph1.setSpacingAfter(25);
            document.add(contentParagraph1);

            // Tekst - Zawartość raportu
            Paragraph contentParagraph2 = new Paragraph("Najmniejszy pożar (powierzchnia): ", font);
            Phrase valuePhrase2 = new Phrase(minValueFireAllStr, boldFont);
            contentParagraph2.add(valuePhrase2);
            contentParagraph2.setIndentationLeft(40);
            contentParagraph2.setSpacingAfter(25);
            document.add(contentParagraph2);

            // Tekst - Zawartość raportu
            Paragraph contentParagraph3 = new Paragraph("Największa zużyta ilość wody: ", font);
            Phrase valuePhrase3 = new Phrase("będzie litrów", boldFont);
            contentParagraph3.add(valuePhrase3);
            contentParagraph3.setIndentationLeft(40);
            contentParagraph3.setSpacingAfter(25);
            document.add(contentParagraph3);

            // Tekst - Zawartość raportu
            Paragraph contentParagraph4 = new Paragraph("Najmniejsza zużyta ilość wody: ", font);
            Phrase valuePhrase4 = new Phrase("będzie litrów", boldFont);
            contentParagraph4.add(valuePhrase4);
            contentParagraph4.setIndentationLeft(40);
            contentParagraph4.setSpacingAfter(25);
            document.add(contentParagraph4);

            // Tekst - Zawartość raportu
            Paragraph contentParagraph5 = new Paragraph("Sumaryczna ilość zużytej wody: ", font);
            Phrase valuePhrase5 = new Phrase("będzie litrów", boldFont);
            contentParagraph5.add(valuePhrase5);
            contentParagraph5.setIndentationLeft(40);
            contentParagraph5.setSpacingAfter(420);
            document.add(contentParagraph5);

            // Pozioma kreska
            LineSeparator lineSeparator2 = new LineSeparator();
            lineSeparator2.setPercentage(90f);
            document.add(lineSeparator2);

            // Stopka - Nazwiska
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);
            table.setSpacingBefore(25);

            Font footerFont = new Font(baseFont, 14, Font.NORMAL, BaseColor.BLACK);

            PdfPCell cell1 = new PdfPCell(new Phrase("Cipior\n273156", footerFont));
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setBorder(NO_BORDER);
            table.addCell(cell1);

            PdfPCell cell2 = new PdfPCell(new Phrase("Iwanicki\n273163", footerFont));
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setBorder(NO_BORDER);
            table.addCell(cell2);

            PdfPCell cell3 = new PdfPCell(new Phrase("Siedlak\n273161", footerFont));
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setBorder(NO_BORDER);
            table.addCell(cell3);

            document.add(table);

            document.close();

            System.out.println("Raport z przeprowadzonej symulacji został wygenerowany.");

            // Otwieranie pliku PDF w przeglądarce
            File pdfFile = new File("raport_z_symulacji.pdf");
            if (pdfFile.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    System.out.println("Otwieranie pliku PDF nie jest obsługiwane na tym systemie.");
                }
            } else {
                System.out.println("Plik PDF nie został znaleziony.");
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
