package ru.liga.dcs.badcode.lesson09;

public class Mortgage {
    double principal;
    double rate;
    int years;

    Mortgage(double principal, double rate, int years) {
        this.principal = principal;
        this.rate = rate;
        this.years = years;
    }

    double calculateMonthlyPayment() {
        // Расчет месячного платежа для ипотеки
        double monthlyRate = rate / 12 / 100;
        double n = years * 12;
        return principal * monthlyRate * Math.pow(1 + monthlyRate, n) / (Math.pow(1 + monthlyRate, n) - 1);
    }
}



