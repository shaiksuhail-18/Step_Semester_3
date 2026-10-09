public class Cart {
    private int[] prices;
    private int itemCount;
    private final String cartId;

    public Cart(String cartId, int capacity) {
        this.cartId = cartId;
        this.prices = new int[capacity];
        this.itemCount = 0;
    }

    public void addItem(int price) {
        if (itemCount < prices.length) {
            prices[itemCount++] = price;
        }
    }

    public int getTotal() {
        int sum = 0;
        for (int i = 0; i < itemCount; i++) {
            sum += prices[i];
        }
        return sum;
    }

    public int getItemCount() {
        return itemCount;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        System.out.println(cart.getTotal());
        System.out.println(cart.getItemCount());
    }
}
