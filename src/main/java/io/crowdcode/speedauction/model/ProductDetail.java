package io.crowdcode.speedauction.model;

import javax.persistence.Entity;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Entity
public class ProductDetail extends Product<ProductDetail> {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductDetail withDescription(final String description) {
        this.description = description;
        return this;
    }

}
