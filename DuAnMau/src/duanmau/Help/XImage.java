/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duanmau.Help;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author NguyenMinhHau_PS24488
 */
public class XImage {

    public static Image getIcon() {
        URL url = XImage.class.getResource("/duanmau/image/icon/...");
        return new ImageIcon(url).getImage();
    }

    public static void Save(File src) {
        File link = new File("HinhAnh", src.getName());
        if (!link.getParentFile().exists()) {
            link.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(link.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

           
    public static ImageIcon Read(String filename) {
        File path = new File("HinhAnh", filename);
        return new ImageIcon(path.getAbsolutePath());
    }
}
