package ru.gb.dev.spring.pfs.notifying.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private String id = "";

    private String login = "";

    private String email = "";

}
