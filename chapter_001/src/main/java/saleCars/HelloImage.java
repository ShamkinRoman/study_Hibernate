package saleCars;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import java.io.OutputStream;

import java.net.URL;

import javax.imageio.ImageIO;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;


/**
 * @author ASaburov
 */

public class HelloImage extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        // ОЧЕНЬ ВАЖНЫЙ МОМЕНТ - надо заранее установить тип возвращаемой информации
        // чтобы броузер мог правильно его показывать. Здесь у нас будет возвращаться картинка
        // в формате PNG
        response.setContentType("image/jpg");
        OutputStream out = response.getOutputStream();
        try {
            // Тут можн загрузить файл с диска не через URL а напрямую - сами найдете
            URL imageURL = HelloImage.class.getResource("E:\\java\\study_Hibernate\\chapter_001\\target\\chapter_001-2.0\\upload\\001.JPG");
            BufferedImage bi = ImageIO.read(imageURL);
            ImageIO.setUseCache(false);
            ImageIO.write(bi, "jpg", out);
        } finally {
            out.close();
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        processRequest(request, response);

//        byte[] content = resultSet.getBytes("content");
//        response.setContentType(getServletContext().getMimeType(imageName));
//        response.setContentLength(content.length);
//        response.getOutputStream().write(content);

        response.setContentType("image/JPG");
        OutputStream out = response.getOutputStream();
        BufferedImage bi = ImageIO.read(new File("E:\\java\\study_Hibernate\\chapter_001\\target\\chapter_001-2.0\\upload\\001.JPG"));
        ImageIO.setUseCache(false);
        ImageIO.write(bi, "jpg", out);
        out.close();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}