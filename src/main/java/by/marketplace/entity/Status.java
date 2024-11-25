package by.marketplace.entity;


public enum Status {
    PENDING("PENDING"),
    PAID("Paid"),
    IN_DELIVERY("In Delivery"),
    DELIVERED("Delivered"),
    CANCELLED("Cancelled");

    Status(String displayValue) {
         displayValue.toUpperCase();
    }
}
