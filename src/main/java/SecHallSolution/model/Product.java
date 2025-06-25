package SecHallSolution.model;

import java.util.Objects;

/**
 * Immutable Product model class.
 */
public final class Product {
    private final String title;
    private final double price;
    private final String imageUrl;

    public Product(String title, double price, String imageUrl) {
        if (title == null || title.isEmpty()) throw new IllegalArgumentException("Title cannot be null or empty");
        if (imageUrl == null || imageUrl.isEmpty()) throw new IllegalArgumentException("Image URL cannot be null or empty");
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        this.title = title;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                title.equals(product.title) &&
                imageUrl.equals(product.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price, imageUrl);
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
