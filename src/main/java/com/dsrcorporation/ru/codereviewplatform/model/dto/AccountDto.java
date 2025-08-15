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
    private Long name;
    private String password;
}
