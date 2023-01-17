package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre os dados do contrato:");
		System.out.print("Numero: ");
		int number = scan.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(scan.next(), fmt);
		System.out.print("Valor do contrato: ");
		double totalValue = scan.nextDouble();
		
		Contract obj = new Contract(number, date, totalValue);
		
		System.out.print("Entre com o numero de parcelas: ");
		int n = scan.nextInt();
		
		ContractService contractService = new ContractService(new PaypalService());
		
		contractService.processContract(obj, n);
		
		System.out.println("Parcelas:");
		
		for (Installment installment : obj.getInstallments()) {
			System.out.println(installment);
		}
		
		scan.close();
	}

}
