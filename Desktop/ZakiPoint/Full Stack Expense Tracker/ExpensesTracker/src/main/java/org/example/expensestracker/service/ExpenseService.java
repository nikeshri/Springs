package org.example.expensestracker.service;

import org.example.expensestracker.dto.DailyExpenseDto;

import java.util.List;

public interface  ExpenseService {

   DailyExpenseDto addExpense(DailyExpenseDto dailyExpenseDto);
   List<DailyExpenseDto> getAllExpenses();
   DailyExpenseDto getExpenseById(Long id);
   DailyExpenseDto updateExpense(Long id, DailyExpenseDto dailyExpenseDto);
   void deleteExpense(Long id);
}
