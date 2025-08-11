package machine;
import machine.states.Idle;
import machine.states.State;
import java.util.*;

public class VendingMachine {
    private State curState;
    private Coin[] coinsInventory;
    private Map<Coin, Integer> insertedCoins = new HashMap<Coin, Integer>();
    private Item selectedProduct;
    private Map<ItemType, Integer> allItems = new HashMap<ItemType, Integer>();


    public VendingMachine() {
        curState = new Idle();
        coinsInventory = Coin.values();
        selectedProduct=null;
        allItems.put(ItemType.COKE, 5);
        allItems.put(ItemType.PEPSI, 1);
    }

    public VendingMachine(int[] coinsInventory) throws Exception{
        this();
        if(this.coinsInventory.length != coinsInventory.length) {
            throw new IllegalArgumentException("Need details regarding all the coins");
        }
        for (int i=0; i<coinsInventory.length; i++) {
            this.coinsInventory[i].addStock(coinsInventory[i]);
        }
    }

    public void sellItem(Item item) {
        allItems.put(item.getItemtype(), allItems.get(item.getItemtype())-1);
        System.out.println("Item "+item.getItemtype().name()+" sold");
    }

    public void setState(State state) {
        if(state instanceof Idle) {
            selectedProduct = null;
            insertedCoins = new HashMap<Coin, Integer>();
        } 
        this.curState = state;
    }

    public State getCurState() {
        return curState;
    }

    public void updateInventory(int[] coinsInventory) throws Exception {
        curState = new Idle();
        this.coinsInventory = Coin.values();
        if(this.coinsInventory.length != coinsInventory.length) {
            throw new IllegalArgumentException("Need details regarding all the coins");
        }
        for (int i=0; i<coinsInventory.length; i++) {
            this.coinsInventory[i].addStock(coinsInventory[i]);
        }
    }

    public void updateInventory(Map<Coin, Integer> coinsInventory) throws Exception {
        for(Coin cn: this.coinsInventory) {
            cn.addStock(coinsInventory.getOrDefault(cn, 0));
        }
    }

    public void insertTransactionCoin(Coin coin, int numberOfCoins) {
        insertedCoins.put(coin, insertedCoins.getOrDefault(coin, 0)+numberOfCoins);
    }

    public Map<Coin, Integer> getInsertedCoindDetails() {
        return insertedCoins;
    }

    public void setItem(Item item) throws Exception {
        if(allItems.getOrDefault(item.getItemtype(), 0)==0) {
            throw new Exception("Item not present, Either select another item or cancel the trasaction");
        }
        selectedProduct = item;
    }

    public Item getItem() {
        return selectedProduct;
    }
}
