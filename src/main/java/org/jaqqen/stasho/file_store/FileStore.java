package org.jaqqen.stasho.file_store;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name="FILE_STORE")
@SequenceGenerator(name = "FILE_STORE_GENERATOR", sequenceName = "FILE_STORE_SEQ", allocationSize = 1)
public class FileStore implements Serializable {
    @Serial
    private static final long serialVersionUID = 6072316235146698599L;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="file_data")
    private Byte[] fileBytes;

    public FileStore(Long id, Byte[] fileBytes) {
        this.id = id;
        this.fileBytes = fileBytes;
    }
}
