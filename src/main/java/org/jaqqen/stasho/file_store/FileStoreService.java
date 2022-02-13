package org.jaqqen.stasho.file_store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileStoreService {
    @Autowired
    private FileStoreRepository fileStoreRepository;

    public List<FileStore> getFileStores() {
        return fileStoreRepository.findAll();
    }

    public void saveAndFlush(MultipartFile multipartFile) throws IOException {
        FileStore fileStore = new FileStore();
        fileStore.setFileBytes(multipartFile.getBytes());
        fileStoreRepository.saveAndFlush(fileStore);
    }

    public FileStore getFileStoreForId(Long id) {
        return fileStoreRepository.findById(id).orElse(null);
    }
}
