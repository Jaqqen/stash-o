package org.jaqqen.stasho.file_store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/file_store/")
public class FileStoreController {
    @Autowired
    private FileStoreService fileStoreService;

    @Value("${my.test.property:#{null}}")
    private String testVar;

    @GetMapping("all")
    public List<FileStore> getFileStores() {
        System.out.println(">>> MY TEST PROPERTY IS: " + testVar);
        return fileStoreService.getFileStores();
    }

    @GetMapping("{id}")
    public FileStore getFileStore(@PathVariable("id") Long id) {
        return fileStoreService.getFileStoreForId(id);
    }

    @PostMapping(path = "", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> saveFileStore(
        @RequestPart("file_data") MultipartFile multipartFile
    ) {
        try {
            fileStoreService.saveAndFlush(multipartFile);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Failed to save file: Couldn't extract bytes from file");
        }

        return ResponseEntity.ok().body("Successfully saved");
    }
}
