package org.bookshop.system.bookshopsystem.models;

import org.bookshop.system.bookshopsystem.models.enums.AgeRestriction;
import org.bookshop.system.bookshopsystem.models.enums.EditionType;

import java.math.BigDecimal;

public interface ReducedBook {
    String getTitle();
    EditionType getEditionType();
    AgeRestriction getAgeRestriction();
    BigDecimal getPrice();
}
