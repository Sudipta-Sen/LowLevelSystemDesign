package machine;
import machine.states.*;

public class Main {
    public static void main(String[] args) {
        try {
            VendingMachine vendingMachine = new VendingMachine();
            State vendingMachineState = vendingMachine.getCurState();
            vendingMachineState.updateInventory(vendingMachine, new int[]{10,10,10,10});
            vendingMachineState.pressInsertCashButton(vendingMachine);

            vendingMachineState = vendingMachine.getCurState();
            vendingMachineState.insertCoin(vendingMachine, Coin.FIVE, 5);
            vendingMachineState.insertCoin(vendingMachine, Coin.TEN, 4);
            vendingMachineState.pressProductSelectionButton(vendingMachine);

            vendingMachineState = vendingMachine.getCurState();
            vendingMachineState.chooseProduct(vendingMachine, 200);
            vendingMachineState.pressDispenseProductButton(vendingMachine);
            
            vendingMachineState = vendingMachine.getCurState();
            vendingMachineState.dispenseProduct(vendingMachine);

            // System.out.println("Vending Machine current state: "+vendingMachine.getCurState().getClass());
            vendingMachineState = vendingMachine.getCurState();
            vendingMachineState.returnChange(vendingMachine);

            System.out.println("Vending Machine current state: "+vendingMachine.getCurState().getClass());

        } catch (Exception e) {
            System.out.println(e);
        }


        
    } 
}
