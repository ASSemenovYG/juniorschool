package ru.liga.dcs.badcode.lesson09;

public class AutoLoan {
    double principal;
    double rate;
    int years;

    AutoLoan(double principal, double rate, int years) {
        this.principal = principal;
        this.rate = rate;
        this.years = years;
    }

    double calculateMonthlyPayment() {
        // Расчет месячного платежа для автокредита может быть немного иным
        double monthlyRate = rate / 12 / 100;
        double n = years * 12;
        // Предполагаем, что есть дополнительный взнос в начале
        double upfrontFee = principal * 0.1; // Например, 10% вперед
        return (principal - upfrontFee) * monthlyRate * Math.pow(1 + monthlyRate, n) / (Math.pow(1 + monthlyRate, n) - 1);
    }
}
