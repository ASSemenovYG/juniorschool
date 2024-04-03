package ru.liga.dcs.badcode.lesson09;

public class Bank {
    public double processLoan(String loanType, double principal, double rate, int years) {
        if (loanType.equals("mortgage")) {
            return calculateMorgageMonthlyPayment(principal, rate, years);
        } else if (loanType.equals("auto")) {
            return calculateAutoLoanMonthlyPayment(principal, rate, years);
        } else if (loanType.equals("personal")) {
            return calculatePersonalLoanMonthlyPayment(principal, rate, years);
        }
        return 0.0;
    }

    private double calculatePersonalLoanMonthlyPayment(double principal, double rate, int years) {
        // Предположим, что ставка может меняться
        // Простой расчет с предположением, что ставка увеличивается каждый год
        double totalPayment = 0;
        double remainingPrincipal = principal;
        for (int year = 1; year <= years; year++) {
            double yearlyRate = rate + year * 0.5; // Увеличение на 0.5% каждый год
            double monthlyRate = yearlyRate / 12 / 100;
            double n = 12; // Количество месяцев в году
            double yearlyPayment = remainingPrincipal * monthlyRate * Math.pow(1 + monthlyRate, n) / (Math.pow(1 + monthlyRate, n) - 1) * n;
            totalPayment += yearlyPayment;
            remainingPrincipal -= yearlyPayment;
        }
        return totalPayment / (years * 12);
    }

    private double calculateAutoLoanMonthlyPayment(double principal, double rate, int years) {
        // Расчет месячного платежа для автокредита может быть немного иным
        double monthlyRate = rate / 12 / 100;
        double n = years * 12;
        // Предполагаем, что есть дополнительный взнос в начале
        double upfrontFee = principal * 0.1; // Например, 10% вперед
        return (principal - upfrontFee) * monthlyRate * Math.pow(1 + monthlyRate, n) / (Math.pow(1 + monthlyRate, n) - 1);
    }

    private double calculateMorgageMonthlyPayment(double principal, double rate, int years) {
        // Расчет месячного платежа для ипотеки
        double monthlyRate = rate / 12 / 100;
        double n = years * 12;
        return principal * monthlyRate * Math.pow(1 + monthlyRate, n) / (Math.pow(1 + monthlyRate, n) - 1);
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        System.out.println("Mortgage Payment: " + bank.processLoan("mortgage", 100000, 5, 30));
        System.out.println("Auto Loan Payment: " + bank.processLoan("auto", 20000, 6, 5));
        System.out.println("Personal Loan Payment: " + bank.processLoan("personal", 5000, 10, 2));
    }
}
