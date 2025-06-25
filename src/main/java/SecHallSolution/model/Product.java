package SecHallSolution.model;

import java.util.Objects;

/**
 * Immutable Product model class.
 */
public final class Product {
    private final String title;
    private final double price;
    private final String imageBase64;

    public Product(String title, double price, String imageBase64) {
        if (title == null || title.isEmpty()) throw new IllegalArgumentException("Title cannot be null or empty");
        if (imageBase64 == null || imageBase64.isEmpty()) throw new IllegalArgumentException("Image cannot be null or empty");
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        this.title = title;
        this.price = price;
        this.imageBase64 = imageBase64;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                title.equals(product.title) &&
                imageBase64.equals(product.imageBase64);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price, imageBase64);
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", imageBase64='" + imageBase64 + '\'' +
                '}';
    }
}
