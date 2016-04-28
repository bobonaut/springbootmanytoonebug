package org.manytoonebug.data.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;
import java.io.Serializable;

/**
 * @author k.kondratov on 4/26/2016.
 */
@MappedSuperclass
public abstract class AbstractEntity<ID extends Serializable> implements Serializable {

    @Version
    private Long version;

    abstract public ID getId();


    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }


    @Transient
    public boolean isNew() {
        return this.version == null;
    }

    /* (non-Javadoc)
         * @see java.lang.Object#equals(java.lang.Object)
         */
    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(obj == this) {
            return true;
        }
        if(!this.getClass().isInstance(obj)) {
            return false;
        }

        AbstractEntity<?> other = this.getClass().cast(obj);

        return
                new EqualsBuilder()
                        .append(this.getId(), other.getId())
                        .isEquals();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return
                new HashCodeBuilder()
                        .append(this.getId())
                        .toHashCode();
    }
}
