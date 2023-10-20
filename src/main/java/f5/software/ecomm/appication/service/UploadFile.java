package f5.software.ecomm.appication.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadFile {

    private final String FOLDER_URI = "images//";
    private final String IMG_DEFAULT = "default.jpg";

    public String upload(MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            byte[] bytes = file.getBytes();
            Path path = Paths.get(FOLDER_URI + file.getOriginalFilename());
            Files.write(path, bytes);
            return file.getOriginalFilename();
        }
        return IMG_DEFAULT;
    }

    public void deleteImage(String nameFile){
        File file = new File(FOLDER_URI + nameFile);
        file.delete();
    }


}
