package machine;

public enum Coin {
    ONE(1),
    TWO(2),
    FIVE(5),
    TEN(10);

    private final int value;
    private int stock;
    

    Coin(int value) {
        this.value = value;
        this.stock = 0;
    }
    public int getValue() {
        return value;
    }

    public int getStock() {
        return this.stock;
    }

    public void withdraStock(int a) throws Exception {
        if(stock-a<0) {
            throw new IllegalArgumentException("Now enough stock for "+this.name());
        } else {
            this.stock -= a;
        }
    }

    public void addStock(int a) {
        this.stock += a;
    }

}
