package com.program.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.program.dto.MediaDTO;
import com.program.service.MediaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/image")
public class MediaController {

    private static String UPLOADED_FOLDER = "/media_upload";
    @Autowired
    private MediaService mediaService;

    @GetMapping("/all")
    public List<MediaDTO> getAll() {
        return mediaService.getAll();
    }

    @PostMapping("/all")
    public MediaDTO save(@RequestBody MediaDTO imageDTO) {
        return mediaService.save(imageDTO);
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity uploadFile(HttpServletRequest request,@RequestParam MultipartFile file) throws IOException {
        MediaDTO mediaDTO = new MediaDTO();
        mediaDTO.setMediaName(file.getOriginalFilename());
        mediaDTO.setMediaSize(file.getSize());
        mediaDTO.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        byte[] bytes = file.getBytes();
        Path path = Paths.get(UPLOADED_FOLDER +"/"+ file.getOriginalFilename());
        System.out.println(path.toAbsolutePath().toString());
        Files.write(path, bytes);
        System.out.println(mediaDTO.toString());
        // logger.info(String.format("File name '%s' uploaded successfully.", file.getOriginalFilename()));
        mediaDTO.setMediaPath(path.toAbsolutePath().toString());
        mediaService.save(mediaDTO);        
        return ResponseEntity.ok().build();
    }
    
    private String doUpload(HttpServletRequest request) {
 
        System.out.println("Description: " + description);
 
        // Thư mục gốc upload file.
        String uploadRootPath = request.getServletContext().getRealPath("upload");
        System.out.println("uploadRootPath=" + uploadRootPath);
 
        File uploadRootDir = new File(uploadRootPath);
        // Tạo thư mục gốc upload nếu nó không tồn tại.
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
        MultipartFile[] fileDatas = myUploadForm.getFileDatas();
        // 
        List<File> uploadedFiles = new ArrayList<File>();
        List<String> failedFiles = new ArrayList<String>();
 
        for (MultipartFile fileData : fileDatas) {
 
            // Tên file gốc tại Client.
            String name = fileData.getOriginalFilename();
            System.out.println("Client File Name = " + name);
 
            if (name != null && name.length() > 0) {
                try {
                    // Tạo file tại Server.
                    File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);
 
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                    stream.write(fileData.getBytes());
                    stream.close();
                    // 
                    uploadedFiles.add(serverFile);
                    System.out.println("Write file: " + serverFile);
                } catch (Exception e) {
                    System.out.println("Error Write file: " + name);
                    failedFiles.add(name);
                }
            }
        }
        model.addAttribute("description", description);
        model.addAttribute("uploadedFiles", uploadedFiles);
        model.addAttribute("failedFiles", failedFiles);
        return "uploadResult";
    }

}