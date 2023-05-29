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
    static double size[] = new double[4];
    static double surface[]= new double[4];
    static double sizead[] = new double[4];
    static double surfacead[] = new double[4];
    public static void ImportData(String[] args){
        FireControl fireControl = new FireControl();
        size[0] = fireControl.getFire0().getHeight();
        surface[0] = size[0]*size[0];
        size[1] = fireControl.getFire1().getHeight();
        surface[1] = size[1]*size[1];
        size[2] = fireControl.getFire2().getHeight();
        surface[2] = size[2]*size[2];
        size[3] = fireControl.getFire3().getHeight();
        surface[3] = size[3]*size[3];
        sizead[0] = fireControl.getAdditionalFire0().getHeight();
        surfacead[0] = sizead[0]*sizead[0];
        sizead[1] = fireControl.getAdditionalFire1().getHeight();
        surfacead[1] = sizead[1]*sizead[1];
        sizead[2] = fireControl.getAdditionalFire2().getHeight();
        surfacead[2] = sizead[2]*sizead[2];
        sizead[3] = fireControl.getAdditionalFire3().getHeight();
        surfacead[3] = sizead[3]*sizead[3];
    }

    public static void GenerateReport(String[] args) {
        FireControl fireControl = new FireControl();
        Document document = new Document();
        HelloApplication helloApp = new HelloApplication();
        boolean booleanadditional[] = new boolean[4];
        booleanadditional[0] = helloApp.getIsUsed0();
        booleanadditional[1] = helloApp.getIsUsed1();
        booleanadditional[2] = helloApp.getIsUsed2();
        booleanadditional[3] = helloApp.getIsUsed3();
        double waterFire[] = new double[4];
        waterFire[0] = surface[0]*1.5;
        waterFire[1] = surface[1]*1.5;
        waterFire[2] = surface[2]*1.5;
        waterFire[3] = surface[3]*1.5;
        double waterFireAd[] = new double[4];
        waterFireAd[0] = surfacead[0]*1.5;
        waterFireAd[1] = surfacead[1]*1.5;
        waterFireAd[2] = surfacead[2]*1.5;
        waterFireAd[3] = surfacead[3]*1.5;
        double waterFireAll = 0;
        waterFireAll = waterFire[0] + waterFire[1] + waterFire[2] + waterFire[3];
        for (int i = 0; i < 4; i++) {
            if (!booleanadditional[i]) { // Sprawdzenie parametru
                waterFireAll += waterFireAd[i];
            }
        }
                System.out.println(fireControl.getAdditionalFire0().getX());
        double maxValueAdFire = 0;
        for (int i = 0; i < 4; i++) {
            if (!booleanadditional[i]) { // Sprawdzenie parametru
                maxValueAdFire = Math.max(maxValueAdFire, surfacead[i]);
            }
        }
        double maxValueFire = 0;
        for (int i = 0; i < 4; i++) {
                maxValueFire = Math.max(maxValueFire, surface[i]);
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
        double minValueAdFire = 1000;
        for (int i = 0; i < 4; i++) {
            if (!booleanadditional[i]) { // Sprawdzenie parametru
                minValueAdFire = Math.min(minValueAdFire, surfacead[i]);
            }
        }
        double minValueFire = 1000;
        for (int i = 0; i < 4; i++) {
            minValueFire = Math.min(minValueFire, surface[i]);
        }
        double minValueFireAll = 1000;
        if(minValueFire>minValueAdFire)
        {
            minValueFireAll=minValueAdFire;
        }
        else
        {
            minValueFireAll=minValueFire;
        }
        String maxValueFireAllStr = Double.toString(maxValueFireAll);
        String minValueFireAllStr = Double.toString(minValueFireAll);
        double CountFire = 4;
        for (int i = 0; i < 4; i++) {
            if (!booleanadditional[i]) { // Sprawdzenie parametru
                CountFire++;
            }
        }
        String CountFireStr = Double.toString(CountFire);
        double waterFireMax = maxValueFireAll*1.5;
        double waterFireMin = minValueFireAll*1.5;
        String waterFireMaxStr = Double.toString(waterFireMax);
        String waterFireMinStr = Double.toString(waterFireMin);
        String waterFireAllStr = Double.toString(waterFireAll);

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
            Phrase valuePhraseunit1 = new Phrase(" metrów kwadratowych", boldFont);
            contentParagraph1.add(valuePhraseunit1);
            contentParagraph1.setSpacingBefore(20); // Ustawienie odstępu po tekście
            contentParagraph1.setIndentationLeft(40);
            contentParagraph1.setSpacingAfter(25);
            document.add(contentParagraph1);

            // Tekst - Zawartość raportu
            Paragraph contentParagraph2 = new Paragraph("Najmniejszy pożar (powierzchnia): ", font);
            Phrase valuePhrase2 = new Phrase(minValueFireAllStr, boldFont);
            contentParagraph2.add(valuePhrase2);
            Phrase valuePhraseunit2 = new Phrase(" metrów kwadratowych", boldFont);
            contentParagraph2.add(valuePhraseunit2);
            contentParagraph2.setIndentationLeft(40);
            contentParagraph2.setSpacingAfter(25);
            document.add(contentParagraph2);

            // Tekst - Zawartość raportu
            Paragraph contentParagraph3 = new Paragraph("Największa zużyta ilość wody: ", font);
            Phrase valuePhrase3 = new Phrase(waterFireMaxStr, boldFont);
            contentParagraph3.add(valuePhrase3);
            Phrase valuePhraseunit3 = new Phrase(" litrów", boldFont);
            contentParagraph3.add(valuePhraseunit3);
            contentParagraph3.setIndentationLeft(40);
            contentParagraph3.setSpacingAfter(25);
            document.add(contentParagraph3);

            // Tekst - Zawartość raportu
            Paragraph contentParagraph4 = new Paragraph("Najmniejsza zużyta ilość wody: ", font);
            Phrase valuePhrase4 = new Phrase(waterFireMinStr, boldFont);
            contentParagraph4.add(valuePhrase4);
            Phrase valuePhraseunit4 = new Phrase(" litrów", boldFont);
            contentParagraph4.add(valuePhraseunit4);
            contentParagraph4.setIndentationLeft(40);
            contentParagraph4.setSpacingAfter(25);
            document.add(contentParagraph4);

            // Tekst - Zawartość raportu
            Paragraph contentParagraph5 = new Paragraph("Sumaryczna ilość zużytej wody: ", font);
            Phrase valuePhrase5 = new Phrase(waterFireAllStr, boldFont);
            contentParagraph5.add(valuePhrase5);
            Phrase valuePhraseunit5 = new Phrase(" litrów", boldFont);
            contentParagraph5.add(valuePhraseunit5);
            contentParagraph5.setIndentationLeft(40);
            contentParagraph5.setSpacingAfter(25);
            document.add(contentParagraph5);

            // Tekst - Zawartość raportu
            Paragraph contentParagraph6 = new Paragraph("Ilość pożarów: ", font);
            Phrase valuePhrase6 = new Phrase(CountFireStr, boldFont);
            contentParagraph6.add(valuePhrase6);
            contentParagraph6.setIndentationLeft(40);
            contentParagraph6.setSpacingAfter(380);
            document.add(contentParagraph6);

            // Pozioma kreska
            LineSeparator lineSeparator2 = new LineSeparator();
            lineSeparator2.setPercentage(90f);
            document.add(lineSeparator2);

            // Stopka - Nazwiska
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);
            table.setSpacingBefore(25);

            Font footerFont = new Font(baseFont, 14, Font.NORMAL, BaseColor.BLACK);

            PdfPCell cell1 = new PdfPCell(new Phrase("Cipior Piotr\n273156", footerFont));
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setBorder(NO_BORDER);
            table.addCell(cell1);

            PdfPCell cell2 = new PdfPCell(new Phrase("Iwanicki Bartosz\n273163", footerFont));
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell2.setBorder(NO_BORDER);
            table.addCell(cell2);

            PdfPCell cell3 = new PdfPCell(new Phrase("Siedlak Maciej\n273161", footerFont));
            cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell3.setBorder(NO_BORDER);
            table.addCell(cell3);

            document.add(table);

            document.close();

            System.out.println("Raport z przeprowadzonej symulacji został wygenerowany.");



            //Sprawdzenie wartości
            System.out.println(size[0]);
            System.out.println(surface[0]);
            System.out.println(surface[1]);
            System.out.println(surface[2]);
            System.out.println(surface[3]);
            System.out.println(surfacead[0]);
            System.out.println(surfacead[1]);
            System.out.println(surfacead[2]);
            System.out.println(surfacead[3]);
            System.out.println(booleanadditional[0]);
            System.out.println(booleanadditional[1]);
            System.out.println(booleanadditional[2]);
            System.out.println(booleanadditional[3]);

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
