package ru.gd.dev.spring.pfs.ui.dto;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * @autor Eremin Artem on 12.03.2019.
 */

@Getter
public enum OperationType {

    INCOME("Income", "/pictures/icons/income.png"),
    ALLOWANCE("Allow", "/pictures/icons/allow.png");

    @NotNull
    private String title;

    @NotNull
    private String icon;

    OperationType(@NotNull final String title, @NotNull final String icon) {
        this.title = title;
        this.icon = icon;
    }

    @Override
    public String toString() {
        return this.getTitle();
    }
}
