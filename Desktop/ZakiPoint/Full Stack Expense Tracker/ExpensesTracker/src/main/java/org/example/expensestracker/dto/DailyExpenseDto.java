package org.example.expensestracker.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Data
@Builder
public class DailyExpenseDto {
    private LocalDate date;
    private String category;
    private double amount;
    private String remark;
}
