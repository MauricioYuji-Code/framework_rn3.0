package utils;

import utils.ImageU;
import utils.PixelCalc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Report {

    public static String generate(String result, int[]error_reduction) {

        StringBuilder sb = new StringBuilder();

        ImageU img = new ImageU(new PixelCalc(),error_reduction);
        img.criaImagem("Graph");

        String report_name = "Report teste";
        String html_head = "<!DOCTYPE html>\n" +
                "<html lang='pt-br'>\n" +
                "<head>\n" +
                "  <meta charset='UTF-8'>\n" +
                "  <meta http-equiv='X-UA-Compatible' content='IE=edge'>\n" +
                "  <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
                "  <title> " + report_name + "</title>\n" +
                "</head>\n";

        String html_body_open_tag = "<body>";

        String html_container_open_tag = "<div class='container'>";
        String html_content_container_open_tag = "<div class='content-container'>";
        String div_close_tag = "</div>";

        String[] lines = result.split("\n");

        sb.append(report_name);
        sb.append(html_head);
        sb.append(html_body_open_tag);
        sb.append(html_container_open_tag);
        sb.append(html_content_container_open_tag);

        for(String l: lines) {
            sb.append("<span>" + l + "</span>");
        }

        sb.append(div_close_tag);

        String html_img = "<img src='Graph.png'>";


        sb.append(div_close_tag);

        String css = "   <style>\n" +
                "        * {\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "            box-sizing: border-box;\n" +
                "            outline: none !important;\n" +
                "        }\n" +
                "\n" +
                "        body {\n" +
                "            display: flex;\n" +
                "            flex-direction: column;\n" +
                "        }\n" +
                "\n" +
                "        html,\n" +
                "        body {\n" +
                "            min-height: 100vh;\n" +
                "        }\n" +
                "\n" +
                "        .container {\n" +
                "            display: flex;\n" +
                "            width: 100%;\n" +
                "            max-width: 1160px;\n" +
                "            margin: 0 auto;\n" +
                "        }\n" +
                "\n" +
                "        .content-container {\n" +
                "            display: flex;\n" +
                "            width: 100%;\n" +
                "            flex-direction: column;\n" +
                "        }\n" +
                "    </style>";

        String html_body_close_tag = "</body>";

        String html_close_tag = "</html>";

        sb.append(css);
        sb.append(html_body_close_tag);
        sb.append(html_close_tag);

        return sb.toString();
    }

    public static void reportPrint(String filePath, String content) {

        FileWriter fw = null;
        try {
            fw = new FileWriter(new File(filePath + ".html"));
            fw.write(content);
            fw.flush();
            fw.close();
        } catch (Exception e) {
            System.out.println("Erro bagulho doido");
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                    System.out.println("Arquivo salvo");
                } catch (IOException e) {
                    System.out.println("Erro ao fechar o aquivo");
                }
            }
        }
    }

}


