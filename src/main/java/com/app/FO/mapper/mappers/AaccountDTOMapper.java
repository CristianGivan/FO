package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.transaction.TransactionDTO;
import com.app.FO.model.transaction.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserDTOMapper.class})
public abstract class TransactionDTOMapper {
    @Autowired
    protected UserDTOMapper userDTOMapper;

    @Mapping(target = "transactionId", source = "id")
    public abstract TransactionDTO transactionToTransactionDTO(Transaction topic);

    public abstract List<TransactionDTO> transactionListToTransactionDTOList(List<Transaction> topic);

}
