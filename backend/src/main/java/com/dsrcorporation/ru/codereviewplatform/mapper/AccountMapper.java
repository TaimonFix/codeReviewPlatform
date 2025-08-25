package com.dsrcorporation.ru.codereviewplatform.mapper;

import com.dsrcorporation.ru.codereviewplatform.model.dto.AccountDto;
import com.dsrcorporation.ru.codereviewplatform.model.entity.Account;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Маппер для работы с аккаунтами.
 */
@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface AccountMapper {

    @Mapping(source ="passwordHash", target = "password")
    AccountDto toDto(Account account);

    @Mapping(target = "accountRole", ignore = true)
    Account toEntity(AccountDto accountDto);
}
