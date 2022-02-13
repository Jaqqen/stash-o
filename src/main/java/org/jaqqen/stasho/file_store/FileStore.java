package org.jaqqen.stasho.file_store;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Arrays;

@Data
@NoArgsConstructor
@Entity
@Table(name="FILE_STORE")
@EntityListeners(AuditingEntityListener.class)
public class FileStore implements Serializable {
    @Serial
    private static final long serialVersionUID = 6072316235146698599L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name="file_data", nullable = false)
    private byte[] fileBytes;

    @Column(name="created_date", nullable = false, updatable = false)
    @CreatedDate
    private ZonedDateTime dtCreated;

    @Column(name="modified_date")
    @LastModifiedDate
    private ZonedDateTime modifiedDate;

    public FileStore(Long id, byte[] fileBytes) {
        this.id = id;
        this.fileBytes = fileBytes;
    }

    @Override
    public String toString() {
        return "FileStore{" +
            "id=" + id +
            ", fileBytes=" + Arrays.toString(fileBytes) +
            '}';
    }
}
