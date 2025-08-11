package machine.states;

import machine.Coin;
import machine.Item;
import machine.ItemType;
import machine.VendingMachine;

public class ProductSelection implements State {
    public ProductSelection() {
        System.out.println("Currently Vending machine is in product selection state");
    }

    @Override
    public void pressInsertCashButton(VendingMachine vendingMachine) throws Exception{
        throw new Exception("Already cash inserted, now select product");
    }

    @Override
    public void pressProductSelectionButton(VendingMachine vendingMachine) throws Exception{
        throw new Exception("Already in product selection state");
    }
    
    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin, int numberOfCoins) throws Exception {
        throw new Exception("Already cash inserted, now select product");
    }
    
    @Override
    public void chooseProduct(VendingMachine vendingMachine, int productCode) throws Exception {
        try {
            ItemType selectedItem = ItemType.getItemByCode(productCode);
            Item product = new Item(selectedItem);
            // System.out.println(product.getItemtype().name());
            vendingMachine.setItem(product);
        } catch(IllegalArgumentException e) {
            System.out.println("No product with code "+productCode);
            return;
        }
    }
    
    @Override
    public void pressDispenseProductButton(VendingMachine vendingMachine) throws Exception {
        if(vendingMachine.getItem()==null) {
            throw new Exception("No item selected");
        }
        vendingMachine.setState(new DispensingProduct());
    }
    
    @Override
    public void dispenseProduct(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Select product to dispense");
    }
    
    @Override
    public void returnChange(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Money can only be refunded in refund state");
    }
    
    @Override
    public void updateInventory(VendingMachine vendingMachine, int[] coinsInventory) throws Exception {
        throw new Exception("Inventory can't be updated in middle of a transaction");
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
