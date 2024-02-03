package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.account.AccountDTO;
import com.app.FO.model.account.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserDTOMapper.class})
public abstract class AccountDTOMapper {
    @Autowired
    protected UserDTOMapper userDTOMapper;

    @Mapping(target = "accountId", source = "id")
    public abstract AccountDTO accountToAccountDTO(Account topic);

    public abstract List<AccountDTO> accountListToAccountDTOList(List<Account> topic);

}
