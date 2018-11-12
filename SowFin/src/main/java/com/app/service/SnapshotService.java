package com.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.SnapshotRepository;
import com.app.model.Snapshot;
import com.app.util.FileStorageException;
import com.app.util.MyFileNotFoundException;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class SnapshotService {

    @Autowired
    private SnapshotRepository dbFileRepository;

    public Snapshot storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            Snapshot dbFile = new Snapshot(fileName, file.getContentType(), file.getBytes(),new Date());

            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Snapshot getFile(int fileId) {
        return dbFileRepository.findById(fileId);
               
    }
    
    
    
    
}
