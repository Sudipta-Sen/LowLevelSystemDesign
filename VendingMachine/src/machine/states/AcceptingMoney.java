package machine.states;

import machine.VendingMachine;
import machine.Coin;

public class AcceptingMoney implements State {

    public AcceptingMoney() {
        System.out.println("Currently Vending machine is in accepting money state");
    }

    @Override
    public void pressInsertCashButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Allready accepting coins");
    }

    @Override
    public void pressProductSelectionButton(VendingMachine vendingMachine) throws Exception{
       vendingMachine.setState(new ProductSelection());
    }
    
    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin, int numberOfCoins) throws Exception {
        vendingMachine.insertTransactionCoin(coin, numberOfCoins);
    }
    
    @Override
    public void chooseProduct(VendingMachine vendingMachine, int productCode) throws Exception {
        throw new Exception("first you need to insert coin");
    }
    
    @Override
    public void pressDispenseProductButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("first you need to insert coin and select product");
    }
    
    @Override
    public void dispenseProduct(VendingMachine vendingMachine) throws Exception {
        throw new Exception("first you need to insert coin and select product");
    }
    
    @Override
    public void returnChange(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Nothing to refund");
    }
    
    @Override
    public void updateInventory(VendingMachine vendingMachine, int[] coinsInventory) throws Exception {
        throw new Exception("Inventory can only be updated in idel state.");
    }
    
    @Override
    public void pressCancel(VendingMachine vendingMachine) throws Exception{
        vendingMachine.setState(new Refund());
    }
    
    @Override
    public void refundFullMoney() throws Exception {
        throw new Exception("Money can only be refunded in refund state");
    }
}
