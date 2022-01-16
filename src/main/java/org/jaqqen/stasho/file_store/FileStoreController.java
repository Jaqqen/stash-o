package org.jaqqen.stasho.file_store;

import org.jaqqen.stasho.file_store.FileStore;
import org.jaqqen.stasho.file_store.FileStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/fileStore/")
public class FileStoreController {
    @Autowired
    private FileStoreService fileStoreService;

    @GetMapping("all")
    public List<FileStore> getFileStores() {
        return fileStoreService.getFileStores();
    }
}
