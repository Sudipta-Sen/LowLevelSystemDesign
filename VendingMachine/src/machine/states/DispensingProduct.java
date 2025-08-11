package machine.states;

import machine.*;
import java.util.*;

public class DispensingProduct implements State {
    public DispensingProduct() throws Exception{
        System.out.println("Currently Vending machine is in dispense product");
        // dispenseProduct(vendingMachine);
    }

    @Override
    public void pressInsertCashButton(VendingMachine vendingMachine) throws Exception{
        throw new Exception("Cash already inserted");
    }

    @Override
    public void pressProductSelectionButton(VendingMachine vendingMachine) throws Exception{
        throw new Exception("product already selected");
    }
    
    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin, int numberOfCoins) throws Exception {
        throw new Exception("Cash already inserted");
    }
    
    @Override
    public void chooseProduct(VendingMachine vendingMachine, int productCode) throws Exception {
        throw new Exception("product already selected");
    }
    
    @Override
    public void pressDispenseProductButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("product is dispensing");
    }
    
    @Override
    public void dispenseProduct(VendingMachine vendingMachine) throws Exception {
        Item item = vendingMachine.getItem();
        int itemPrice = item.getPrice();
        Map<Coin, Integer> coinsInserted = vendingMachine.getInsertedCoindDetails();
        int totalValue = 0;
        for(Coin cn:coinsInserted.keySet()) {
            totalValue += (coinsInserted.get(cn)*cn.getValue());
        }

        if(totalValue<itemPrice) {
            throw new Exception("Money inserted is not sufficient to buy the product");
        }
        vendingMachine.sellItem(item);

        System.out.println("About to set refund state" );
        vendingMachine.setState(new Refund());

    }
    
    @Override
    public void returnChange(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Money only be refunded in refund state");
    }
    
    @Override
    public void updateInventory(VendingMachine vendingMachine, int[] coinsInventory) throws Exception {
        vendingMachine.updateInventory(coinsInventory);
    }
    
    @Override
    public void pressCancel(VendingMachine vendingMachine) {
        System.out.println("Product is dispensing can't cancle now");
    }
    
    @Override
    public void refundFullMoney() throws Exception {
        throw new Exception("Money only be refunded in refund state");
    }
}
