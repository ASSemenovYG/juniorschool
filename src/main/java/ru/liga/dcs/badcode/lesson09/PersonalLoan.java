package ru.liga.dcs.badcode.lesson09;

public class PersonalLoan {
    double principal;
    double rate;
    int years;

    PersonalLoan(double principal, double rate, int years) {
        this.principal = principal;
        this.rate = rate;
        this.years = years;
    }

    double calculateMonthlyPayment() {
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
}
