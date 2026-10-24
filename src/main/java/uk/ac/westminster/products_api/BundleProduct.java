package uk.ac.westminster.products_api;

import java.util.List;

public class BundleProduct extends Product{

        private List<Product> items;

        public BundleProduct() {}

        public BundleProduct(Long id, String name, double price, List<Product> items) {
            super(id, name, price);
            this.items = items;
        }

        public List<Product> getItems() {
            return items;
        }

        public void setItems(List<Product> items) {
            this.items = items;
        }

        /*
         * IS-A vs HAS-A:
         * BundleProduct can be considered a Product because a bundle can be
         * sold as a single item with its own ID, name, and price.
         * However, it also HAS-A relationship with other Products through
         * its List<Product> field. Inheritance is reasonable if bundles
         * behave like ordinary products in the application. If a bundle
         * only groups existing products together, composition without
         * inheritance might be a better design.
         */
}
