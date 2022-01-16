package org.jaqqen.stasho.file_store;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FileStoreRepository extends JpaRepository<FileStore, Long> {
}