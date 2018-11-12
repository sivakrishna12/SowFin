package com.app.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.model.Snapshot;
import com.app.util.Output;
import com.app.util.ResponseCode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import com.app.service.SnapshotService;
@RestController
@RequestMapping("/api/v1")
public class SnapshotController {

   // private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private SnapshotService DBFileStorageService;

    @PostMapping("/snapshot")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        Snapshot dbFile = DBFileStorageService.storeFile(file);
       
        return new ResponseEntity<>(new Output(0, new ResponseCode("ok","Created",dbFile.getId()),""),HttpStatus.OK);
    	
    }

    /*@PostMapping("/snapshots")
    public List<?> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()          
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
                
    }*/
   
    
   /*@GetMapping("/snapshot/{id}")
   
    public ResponseEntity<?> downloadFile(@PathVariable("id") int id) {
        // Load file from database
        Snapshot dbFile = DBFileStorageService.getFile(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
        
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getSnapshot()));
    }*/
    
}
