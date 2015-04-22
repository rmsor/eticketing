/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

/**
 *
 * @author rmsor_000
 */
@Named("ImageHelper")
@RequestScoped
public class ImageHelper {

    private static String extension;

    private static String message;

    private static String newFileName;

    private static final int BUFFER_SIZE = 3000000;

    public static String getMessage() {
        return message;
    }

    public static void setMessage(String msg) {
        message = msg;
    }

    public static String getExtension() {
        return extension;
    }

    public static String getNewFileName() {
        return newFileName;
    }

    public static String upload(Part file1, String OldImage, String folderName) throws IOException {

        InputStream inputStream = null;
        OutputStream outputStream = null;
        FacesContext context = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
        String path = servletContext.getRealPath("");
        boolean file1Success = false;

        String fileName = "";

        if (file1.getSize() > 0) {
            fileName = getFileNameFromPart(file1);
            extension = fileName.substring(fileName.lastIndexOf(".") + 1);
            newFileName = randInt(1111, 999999999) + fileName;
            /**
             * destination where the file will be uploaded
             */

            File outputFile = new File(path + File.separator + "resources" + File.separator + folderName + File.separator + newFileName);
            inputStream = file1.getInputStream();
            outputStream = new FileOutputStream(outputFile);
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = 0;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            file1Success = true;
        }

        if (file1Success) {
            System.out.println("File uploaded to : " + path);
            /**
             * set the success message when the file upload is successful
             */
            setMessage("File successfully uploaded to " + path);

            if (!OldImage.equals("")) {
                String chunks[] = OldImage.split("/");
                String oldfile = chunks[chunks.length-1];
                File oldfileD = new File(path + File.separator + "resources"
                        + File.separator + folderName + File.separator + oldfile);
                oldfileD.setWritable(true);
                oldfileD.delete();
            }
        } else {
            /**
             * set the error message when error occurs during the file upload
             */
            setMessage("Error, select atleast one file!");
            return "fail";
        }

        return "success";

    }

    public static String getFileNameFromPart(Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {
                String fileName = content.substring(content.indexOf('=') + 1)
                        .trim().replace("\"", "");
                return fileName;
            }
        }
        return null;
    }

    public void validateFile(FacesContext con, UIComponent comp, Object value) {
        Part p = (Part) value;
        if (p != null) {
            List<FacesMessage> list = new ArrayList<>();
            if (p.getSize() == 0) {
                list.add(new FacesMessage("File Size too small"));
            }
            if (p.getSize() > BUFFER_SIZE) {
                list.add(new FacesMessage("File Size too Big"));
            }

            if (!("image/png".equals(p.getContentType()) || "image/jpeg".equals(p.getContentType()))) {
                list.add(new FacesMessage("not an image file"));
            }

            if (!list.isEmpty()) {
                throw new ValidatorException(list);
            }
        }
    }

    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
