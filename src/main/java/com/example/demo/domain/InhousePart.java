package com.example.demo.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 *
 *
 *
 */
@Entity
@DiscriminatorValue("1")
public class InhousePart extends Part{
    int partId;
    private int minInv;
    private int maxInv;

    public InhousePart() {
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }
    public int getMinInv() {
        return minInv;
    }

    public void setMinInv(int minInv) {
        this.minInv = minInv;
    }

    public int getMaxInv() {
        return maxInv;
    }

    public void setMaxInv(int maxInv) {
        this.maxInv = maxInv;
    }
}
