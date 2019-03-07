package ru.gd.dev.spring.pfs.ui.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * @autor Eremin Artem on 26.02.2019.
 */

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AccountType {
    DEBIT_CARD("Debit Card", "account.type.debitcard", "/pictures/icons/debitCard.png"),
    CREDIT_CARD("Credit Card", "account.type.creditcard", "/pictures/icons/creditCard.png"),
    CREDIT("Credit", "account.type.credit", "/pictures/icons/credit.png"),
    DEPOSIT("Deposit", "account.type.deposit", "/pictures/icons/deposit.png"),
    CASH("Cash", "account.type.cash", "/pictures/icons/cash.png");

    @NotNull
    @JsonValue
    private String title;

    @NotNull
    @JsonValue
    private String messagePath;

    @NotNull
    @JsonValue
    private String icon;

    AccountType(@NotNull final String title, @NotNull final String messagePath, @NotNull final String icon) {
        this.title = title;
        this.messagePath = messagePath;
        this.icon = icon;
    }

    @Override
    public String toString() {
        return this.getTitle();
    }
}
