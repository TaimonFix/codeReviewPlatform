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

    /**
     * Маппинг: {@link Account} -> {@link AccountDto}.
     *
     * @param account сущность "аккаунт".
     * @return {@link AccountDto} dto "аккаунта".
     */
    @Mapping(source ="passwordHash", target = "password")
    AccountDto toDto(Account account);

    /**
     * Маппинг: {@link AccountDto} -> {@link Account}.
     *
     * @param accountDto dto "аккаунта".
     * @return {@link Account} сущность "аккаунт".
     */
    @Mapping(target = "accountRole", ignore = true)
    Account toEntity(AccountDto accountDto);
}
