package zhangyi.refactoring.extractmethod;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<Double> discounts;
    private List<Double> itemTotals;

    public Receipt() {
        discounts = new ArrayList<>();
        itemTotals = new ArrayList<>();
    }

    public void addDiscount(double discount) {
        discounts.add(discount);
    }

    public void addItemTotal(double itemTotal) {
        itemTotals.add(itemTotal);
    }

    public double calculateGrandTotal() {
        double subTotal = calculateTotal();
        subTotal = calculateDiscount(subTotal);
        subTotal = calculateTax(subTotal);
        return subTotal;
    }

    private static double calculateTax(double subTotal) {
        double tax = subTotal * 0.065;
        subTotal += tax;
        return subTotal;
    }

    private double calculateDiscount(double subTotal) {
        if (discounts.size() > 0) {
            for (double discount : discounts)
                subTotal -= discount;
        }
        return subTotal;
    }

    private double calculateTotal() {
        double subTotal = 0;
        for (double itemTotal : itemTotals) {
            subTotal += itemTotal;
        }
        return subTotal;
    }
}
