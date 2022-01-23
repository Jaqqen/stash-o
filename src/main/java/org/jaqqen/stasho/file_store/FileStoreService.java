package org.jaqqen.stasho.file_store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileStoreService {
    @Autowired
    private FileStoreRepository fileStoreRepository;

    public List<FileStore> getFileStores() {
        return fileStoreRepository.findAll();
    }

    public void save(FileStore fileStore) {
        fileStoreRepository.saveAndFlush(fileStore);
    }

    public FileStore getFileStoreForId(Long id) {
        return fileStoreRepository.findById(id).orElse(null);
    }
}
