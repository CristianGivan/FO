package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.expenses.ExpensesDTO;
import com.app.FO.model.expenses.Expenses;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserDTOMapper.class})
public abstract class ExpensesDTOMapper {
    @Autowired
    protected UserDTOMapper userDTOMapper;

    @Mapping(target = "expensesId", source = "id")
    public abstract ExpensesDTO expensesToExpensesDTO(Expenses topic);

    public abstract List<ExpensesDTO> expensesListToExpensesDTOList(List<Expenses> topic);

}
