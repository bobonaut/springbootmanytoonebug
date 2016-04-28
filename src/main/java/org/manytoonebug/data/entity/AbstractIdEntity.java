package org.manytoonebug.data.entity;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * @author k.kondratov on 4/26/2016.
 */
@MappedSuperclass
public class AbstractIdEntity extends AbstractEntity<UUID> {

    private static final long serialVersionUID = 1L;

    @Id
    @Type(type="uuid-char")
    @Column(name = "id", length = 36)
    private UUID id;

    public AbstractIdEntity() {
        this.id = UUID.randomUUID();
    }

    @Override
    public UUID getId() {
        return this.id;
    }
}
