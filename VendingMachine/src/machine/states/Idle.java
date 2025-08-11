package machine.states;

import machine.VendingMachine;
import machine.Coin;

public class Idle implements State {
    public Idle() {
        System.out.println("Currently Vending machine is in idel state");
    }

    @Override
    public void pressInsertCashButton(VendingMachine vendingMachine) {
        vendingMachine.setState(new AcceptingMoney());
    }

    @Override
    public void pressProductSelectionButton(VendingMachine vendingMachine) throws Exception{
        throw new Exception("first you need to insert coin");
    }
    
    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin, int numberOfCoins) throws Exception {
        throw new Exception("Please press insert cash button to insert coin");
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
        vendingMachine.updateInventory(coinsInventory);
    }
    
    @Override
    public void pressCancel(VendingMachine vendingMachine) {
        System.out.println("Nothing to cancle");
    }
    
    @Override
    public void refundFullMoney() throws Exception {
        throw new Exception("Nothing to refund");
    }
}
