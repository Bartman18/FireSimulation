package com.example.testtow;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.xhtmlrenderer.pdf.ITextRenderer;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.FontFactory;

public class GenerateReport {

    public static void GenerateReport() {
        System.out.println(System.getProperty("file.encoding"));

        FontFactory.register("fonts/ARIALUNI.TTF", "MyArialUnicode");

        String htmlContent = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"></meta>\n" +
                "    <meta charset=\"UTF-8\"></meta>\n" +
                "    <title>Document</title>\n" +
                "    <style>\n" +
                "        @page {\n" +
                "            size: A4;\n" +
                "            margin: 0;\n" +
                "        }\n" +
                "        \n" +
                "        * {\n" +
                "            font-family: Arial Unicode MS;\n" +
                "        }\n" +
                "        body {\n" +
                "            margin: 40px;\n" +
                "            font-family: Arial, sans-serif;\n" +
                "        }\n" +
                "        \n" +
                "        h1 {\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "        \n" +
                "        hr {\n" +
                "            border: none;\n" +
                "            height: 2px;\n" +
                "            background-color: #000;\n" +
                "            margin-top: 20px;\n" +
                "            margin-bottom: 20px;\n" +
                "        }\n" +
                "        \n" +
                "        p {\n" +
                "            margin-top: 10px;\n" +
                "            margin-bottom: 10px;\n" +
                "        }\n" +
                "        \n" +
                "        table {\n" +
                "            width: 100%;\n" +
                "            margin-top: 20px;\n" +
                "            margin-bottom: 20px;\n" +
                "        }\n" +
                "        \n" +
                "        td {\n" +
                "            width: 33.33%;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Raport z przeprowadzonej symulacji</h1>\n" +
                "    <hr></hr>\n" +
                "    <p>Czas trwania przeprowadzonej symulacji: <b>12:07</b></p>\n" +
                "    <p>Ilość wygenerowanych pożarów: <b>8</b></p>\n" +
                "    <p>Całkowita ilość zużytej wody: <b>27 529 l</b></p>\n" +
                "    <p>Średnia ilość zużytej wody do jednego pożaru: <b>2 507 l</b></p>\n" +
                "    <p>Najmniejsza ilość zużytej wody do jednego pożaru: <b>1 358 l</b></p>\n" +
                "    <p>Największa ilość zużytej wody do jednego pożaru: <b>4 326 l</b></p>\n" +
                "    <p>Najkrótszy czas dojazdu zastępu do pożaru: <b>00:17</b></p>\n" +
                "    <p>Najdłuższy czas dojazdu zastępu do pożaru: <b>01:13</b></p>\n" +
                "    <p>Średni czas dojazdu zastępu do pożaru: <b>00:53</b></p>\n" +
                "    <hr></hr>\n" +
                "    <h3>System wykonany przez:</h3>\n" +
                "    <table>\n" +
                "        <tr>\n" +
                "            <td>Piotr Cipior 273156</td>\n" +
                "            <td>Bartosz Iwanicki 273163</td>\n" +
                "            <td>Maciej Siedlak 273161</td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "</body>\n" +
                "</html>\n";

        try {

            OutputStream outputStream = new FileOutputStream("raport.pdf");
            ITextRenderer renderer = new ITextRenderer();


            // Ustawienie rozwiązania czcionek
            renderer.getFontResolver().addFont("fonts/ARIALUNI.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

            renderer.setDocumentFromString("halko");
            renderer.setDocumentFromString(/*htmlContent*/"git");
            renderer.layout();
            renderer.createPDF(outputStream);
            renderer.finishPDF();
            outputStream.close();
            System.out.println("PDF został wygenerowany prawidłowo.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
