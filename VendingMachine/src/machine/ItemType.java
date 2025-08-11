package machine;

public enum ItemType {
    COKE(100) {
        @Override
        public int getPrice() {
            return 10;
        }
    },
    PEPSI(200) {
        @Override
        public int getPrice() {
            return 50;
        }
    },
    JUICE(300) {
        @Override
        public int getPrice() {
            return 20;
        }
    },
    SODA(400) {
        @Override
        public int getPrice() {
            return 25;
        }
    };

    private final int code;

    ItemType(int code) {
        this.code = code;
    }

    public static ItemType getItemByCode(int code) throws Exception{
        for(ItemType item: ItemType.values()) {
            if(item.getCode()==code) {
                return item;
            }
        }
        throw new IllegalArgumentException("No item found for code "+code);
    }

    public abstract int getPrice();
    public int getCode() {
        return code;
    }
}
