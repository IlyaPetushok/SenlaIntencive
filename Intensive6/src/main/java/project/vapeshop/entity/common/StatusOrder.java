package project.vapeshop.entity.common;

public enum StatusOrder {
    Accepted("привнят"),
    Sent("отправлен"),
    Arrived("прибыл");

    String name;

    StatusOrder(String name) {
        this.name = name;
    }
}
