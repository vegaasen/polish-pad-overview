package com.vegaasen.web.service.polish.common.domain.pad;

import com.vegaasen.web.service.polish.common.domain.brand.Brand;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
@Entity
public class Pad implements Serializable {

    private static final long serialVersionUID = 42L;

    @Id
    @GeneratedValue
    private Long id;
    @NaturalId
    @Column(nullable = false)
    private String name;
    @Column(length = 2000)
    private String description;
    @Column
    private String directLink;
    @Column
    private PadSpecification specification = PadSpecification.empty();
    @Column(nullable = false)
    @Enumerated(value = EnumType.ORDINAL)
    private PadType padType;
    @ManyToOne(optional = false)
    private Brand brand;
    @Column(nullable = false, name = "idx")
    private int index;

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

    public String getDirectLink() {
        return directLink;
    }

    public void setDirectLink(String directLink) {
        this.directLink = directLink;
    }

    public PadSpecification getSpecification() {
        return specification;
    }

    public void setSpecification(PadSpecification specification) {
        this.specification = specification;
    }

    public PadType getPadType() {
        return padType;
    }

    public void setPadType(PadType padType) {
        this.padType = padType;
    }

    public Brand getBrand() {
        return brand;
    }

    public int getIndex() {
        return index;
    }

}
