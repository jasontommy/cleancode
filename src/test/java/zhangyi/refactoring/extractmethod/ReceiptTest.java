package zhangyi.refactoring.extractmethod;

import org.junit.Assert;
import org.junit.Test;

public class ReceiptTest {

    @Test
    public void test_calculateGrandTotal_without_discount() {
        Receipt receipt = new Receipt();
        receipt.addItemTotal(400d);
        receipt.addItemTotal(600d);
        double grandTotal = receipt.calculateGrandTotal();
        double except = 1065d;
        Assert.assertEquals(except, grandTotal, 0);
    }

    @Test
    public void test_calculateGrandTotal_with_discount() {
        Receipt receipt = new Receipt();
        receipt.addItemTotal(400d);
        receipt.addItemTotal(600d);
        receipt.addDiscount(200d);
        receipt.addItemTotal(200d);
        double grandTotal = receipt.calculateGrandTotal();
        double except = 1065d;
        Assert.assertEquals(except, grandTotal, 0);
    }

}