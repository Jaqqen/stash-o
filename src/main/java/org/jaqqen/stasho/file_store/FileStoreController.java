package org.jaqqen.stasho.file_store;

import org.hibernate.internal.build.AllowSysOut;
import org.jaqqen.stasho.file_store.FileStore;
import org.jaqqen.stasho.file_store.FileStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/file_store/")
public class FileStoreController {
    @Autowired
    private FileStoreService fileStoreService;

    @GetMapping("all")
    public List<FileStore> getFileStores() {
        return fileStoreService.getFileStores();
    }

   @GetMapping("{id}")
   public FileStore getFileStore(@PathVariable("id") Long id) {
        return fileStoreService.getFileStoreForId(id);
   }

   @PostMapping(path = "", consumes = {MediaType.APPLICATION_JSON_VALUE})
   public void saveFileStore(@RequestBody FileStore fileStore) {
        System.out.println(fileStore);
        fileStoreService.save(fileStore);
   }
}
