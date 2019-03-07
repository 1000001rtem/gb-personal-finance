package ru.gb.dev.spring.pfs.accounting.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

@Data
@NoArgsConstructor
public class ResultDto {

    @Nullable
    private String message = "";

    @Nullable
    private Boolean success = true;

}
