package com.kodgemisi.ornek.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ItemAddForm {
    @NotEmpty
    @Size(max = 50, min = 2)
    private String itemType;

    @NotNull
    private int amount = 1;

    public String getItemType() {

        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
