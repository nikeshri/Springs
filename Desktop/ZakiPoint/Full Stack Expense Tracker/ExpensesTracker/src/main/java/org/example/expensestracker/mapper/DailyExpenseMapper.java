package org.example.expensestracker.mapper;

import org.example.expensestracker.dto.DailyExpenseDto;
import org.example.expensestracker.model.DailyExpense;
import org.springframework.stereotype.Component;

@Component
public class DailyExpenseMapper {

    public DailyExpense toEntity(DailyExpenseDto dto) {
        DailyExpense entity = new DailyExpense();
        entity.setDate(dto.getDate());
        entity.setCategory(dto.getCategory());
        entity.setAmount(dto.getAmount());
        entity.setRemark(dto.getRemark());
        return entity;
    }

    public DailyExpenseDto toDto(DailyExpense entity) {
        return DailyExpenseDto.builder()
                .date(entity.getDate())
                .category(entity.getCategory())
                .amount(entity.getAmount())
                .remark(entity.getRemark())
                .build();
    }
}