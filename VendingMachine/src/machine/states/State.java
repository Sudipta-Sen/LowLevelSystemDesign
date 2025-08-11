package machine.states;
import machine.Coin;
import machine.VendingMachine;

public interface State {
    public void pressInsertCashButton(VendingMachine vendingMachine) throws Exception;
    public void pressProductSelectionButton(VendingMachine vendingMachine) throws Exception;
    public void insertCoin(VendingMachine vendingMachine, Coin coin, int numberOfCoins) throws Exception;
    public void chooseProduct(VendingMachine vendingMachine, int productCode) throws Exception;
    public void pressDispenseProductButton(VendingMachine vendingMachine) throws Exception;
    public void dispenseProduct(VendingMachine vendingMachine) throws Exception;
    public void returnChange(VendingMachine vendingMachine) throws Exception;
    public void updateInventory(VendingMachine vendingMachine, int[] coinsInventory) throws Exception;
    public void pressCancel(VendingMachine vendingMachine) throws Exception;
    public void refundFullMoney() throws Exception;
}
