package machine.states;

import java.util.IdentityHashMap;
import java.util.Map;

import machine.Coin;
import machine.Item;
import machine.VendingMachine;

public class Refund implements State {
    public Refund() throws Exception {
        System.out.println("Currently Vending machine is in refund state");
    }

    @Override
    public void pressInsertCashButton(VendingMachine vendingMachine) throws Exception{
        throw new Exception("no more money excepted");
    }

    @Override
    public void pressProductSelectionButton(VendingMachine vendingMachine) throws Exception{
        throw new Exception("product already selected");
    }
    
    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin, int numberOfCoins) throws Exception {
        throw new Exception("no more coin");
    }
    
    @Override
    public void chooseProduct(VendingMachine vendingMachine, int productCode) throws Exception {
        throw new Exception("product already selected");
    }
    
    @Override
    public void pressDispenseProductButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("product already selected");
    }
    
    @Override
    public void dispenseProduct(VendingMachine vendingMachine) throws Exception {
        throw new Exception("product already selected");
    }
    
    @Override
    public void returnChange(VendingMachine vendingMachine) throws Exception {
        vendingMachine.updateInventory(vendingMachine.getInsertedCoindDetails());
        Item item = vendingMachine.getItem();
        int itemPrice = item.getPrice();
        Map<Coin, Integer> coinsInserted = vendingMachine.getInsertedCoindDetails();
        int totalValue = 0;
        for(Coin cn:coinsInserted.keySet()) {
            totalValue += (coinsInserted.get(cn)*cn.getValue());
        }
        int returnAmount = totalValue - itemPrice;
        System.out.println("Total return amount "+returnAmount);
        Coin[] coins = Coin.values();
        for(int i=coins.length-1; i>=0; i--) {
            Coin coin = coins[i];
            int count = returnAmount/coin.getValue();
            coin.withdraStock(count);
            if(count>0) {
                returnAmount -= count*coin.getValue();
                System.out.println("Return "+coin.name()+ " rupee coins, count="+count);
            }
        }
        vendingMachine.setState(new Idle());
    }
    
    @Override
    public void updateInventory(VendingMachine vendingMachine, int[] coinsInventory) throws Exception {
        throw new Exception("Inventory can't be updated in middle of a transaction");
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
