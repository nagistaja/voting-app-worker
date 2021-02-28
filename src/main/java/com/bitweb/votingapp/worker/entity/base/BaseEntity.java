package com.bitweb.votingapp.worker.entity.base;

import com.bitweb.votingapp.worker.util.Identifiable;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxyHelper;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Setter
@ToString
public abstract class BaseEntity implements Identifiable<Long>, java.io.Serializable {
    private static final long serialVersionUID = -4158937274633154129L;

    @SuppressWarnings({ "checkstyle:VisibilityModifier" })
    protected Long id;

    /** Returns id */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "assigned-sequence")
    @Column(unique = true, nullable = false)
    @Override
    public Long getId() {
        return id;
    }

    @SuppressWarnings({ "checkstyle:AvoidInlineConditionals" })
    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.getId() == null) ? 0 : this.getId().hashCode());
        result = prime * result + getClass().hashCode();
        return result;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof BaseEntity)) {
            return false;
        }
        if (!HibernateProxyHelper.getClassWithoutInitializingProxy(this)
                .equals(HibernateProxyHelper.getClassWithoutInitializingProxy(obj))) {
            return false;
        }
        BaseEntity other = (BaseEntity) obj;
        if (this.getId() == null || other.getId() == null) {
            return false;
        } else if (!this.getId().equals(other.getId())) {
            return false;
        }
        return true;
    }
}
