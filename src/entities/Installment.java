package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
	
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private LocalDate duoDate;
	private Double amount;

	public Installment() {
	}

	public Installment(LocalDate duoDate, Double amount) {
		this.duoDate = duoDate;
		this.amount = amount;
	}

	public LocalDate getDuoDate() {
		return duoDate;
	}

	public void setDuoDate(LocalDate duoDate) {
		this.duoDate = duoDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return duoDate.format(fmt) + " - " + String.format("%.2f", amount);
	}
}
