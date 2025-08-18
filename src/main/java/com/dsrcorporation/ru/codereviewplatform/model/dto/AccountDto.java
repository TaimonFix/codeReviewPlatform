package com.dsrcorporation.ru.codereviewplatform.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO - аккаунт пользователя.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private String name;
    private String password;
    private String role;
}
