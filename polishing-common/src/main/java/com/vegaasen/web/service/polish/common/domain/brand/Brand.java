package com.vegaasen.web.service.polish.common.domain.brand;

import com.vegaasen.web.service.polish.common.domain.pad.Pad;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
@Entity
@Table(name = "Brand")
public class Brand implements Serializable {

    private static final long serialVersionUID = 42L;

    @Id
    @GeneratedValue
    private Long id;
    @NaturalId
    @Column(nullable = false)
    private String name;
    @Column
    private String description;
    @Column
    private String url;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pads")
    private Set<Pad> pads;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Set<Pad> getPads() {
        return pads;
    }

    public void setPads(Set<Pad> pads) {
        this.pads = pads;
    }
}
