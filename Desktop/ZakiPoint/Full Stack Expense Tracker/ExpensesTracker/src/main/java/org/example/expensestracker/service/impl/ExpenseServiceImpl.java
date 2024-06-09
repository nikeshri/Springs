package org.example.expensestracker.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.expensestracker.dto.DailyExpenseDto;
import org.example.expensestracker.mapper.DailyExpenseMapper;
import org.example.expensestracker.model.DailyExpense;
import org.example.expensestracker.repo.DailyRepo;
import org.example.expensestracker.service.ExpenseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final DailyExpenseMapper dailyExpenseMapper;
    private final DailyRepo dailyRepo;

    @Override
    public DailyExpenseDto addExpense(DailyExpenseDto dailyExpenseDto) {
        DailyExpense dailyExpense = dailyExpenseMapper.toEntity(dailyExpenseDto);
        DailyExpense savedExpense = dailyRepo.save(dailyExpense);
        return dailyExpenseMapper.toDto(savedExpense);
    }

    @Override
    public List<DailyExpenseDto> getAllExpenses() {
        return dailyRepo.findAll().stream()
                .map(dailyExpenseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DailyExpenseDto getExpenseById(Long id) {
        return dailyRepo.findById(id)
                .map(dailyExpenseMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
    }

    @Override
    public void deleteExpense(Long id) {
        dailyRepo.deleteById(id);
    }

    @Override
    public DailyExpenseDto updateExpense(Long id, DailyExpenseDto dailyExpenseDto) {
        DailyExpense existingExpense = dailyRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        existingExpense.setDate(dailyExpenseDto.getDate());
        existingExpense.setCategory(dailyExpenseDto.getCategory());
        existingExpense.setAmount(dailyExpenseDto.getAmount());
        existingExpense.setRemark(dailyExpenseDto.getRemark());

        DailyExpense updatedExpense = dailyRepo.save(existingExpense);
        return dailyExpenseMapper.toDto(updatedExpense);
    }
}
