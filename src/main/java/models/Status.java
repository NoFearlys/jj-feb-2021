package models;

public enum Status {
    NOTHING (1, "Пусто"),
    WAITING (2, "Ожидается"),
    OPERATION (3, "В работе"),
    SENT (4, "Отправлено"),
    RECEIVED (5, "Получено"),
    PAID (6, "Оплачено");

    int id;
    String title;

    Status(int id, String title){
        this.id=id;
        this.title = title;
    }
}
