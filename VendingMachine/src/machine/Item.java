package machine;

public class Item {
    private ItemType itemType;
    public Item(ItemType itemType) {
        this.itemType = itemType;
    }

    public ItemType getItemtype() {
        return itemType;
    }

    public int getPrice() {
        return itemType.getPrice();
    }
}
