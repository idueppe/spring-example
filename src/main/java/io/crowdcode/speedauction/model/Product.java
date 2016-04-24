package io.crowdcode.speedauction.model;

import io.crowdcode.speedauction.commons.AbstractEntity;
import io.crowdcode.speedauction.commons.Identifiable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.math.BigDecimal;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Product<T extends Product> extends AbstractEntity<T, Long> implements Identifiable<Long> {

    private String title;
    private BigDecimal minAmount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    @SuppressWarnings("unchecked")
    public T withTitle(final String title) {
        this.title = title;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T withMinAmount(final BigDecimal minAmount) {
        this.minAmount = minAmount;
        return (T) this;
    }


}
