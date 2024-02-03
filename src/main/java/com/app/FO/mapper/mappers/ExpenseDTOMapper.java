package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.expense.ExpenseDTO;
import com.app.FO.model.expense.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserDTOMapper.class})
public abstract class ExpenseDTOMapper {
    @Autowired
    protected UserDTOMapper userDTOMapper;

    @Mapping(target = "expenseId", source = "id")
    public abstract ExpenseDTO expenseToExpenseDTO(Expense topic);

    public abstract List<ExpenseDTO> expenseListToExpenseDTOList(List<Expense> topic);

}
