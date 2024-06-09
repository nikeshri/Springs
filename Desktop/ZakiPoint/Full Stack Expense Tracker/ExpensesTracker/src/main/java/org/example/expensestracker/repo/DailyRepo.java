package org.example.expensestracker.repo;

import org.example.expensestracker.model.DailyExpense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyRepo extends JpaRepository<DailyExpense, Long> {
}
