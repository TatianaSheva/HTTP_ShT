import com.fasterxml.jackson.annotation.JsonProperty;

public class Cat {
    private final String id; // Уникальный идентификатор записи
    private final String text; // Сообщение
    private final String type; // тип животного
    private final String user; // Имя пользователя
    private final String upvotes; // Голоса

    public Cat(
            @JsonProperty("id") String id,
            @JsonProperty("text") String text,
            @JsonProperty("type") String type,
            @JsonProperty("user") String user,
            @JsonProperty("upvotes") String upvotes
    ) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upvotes = upvotes;
    }

    public String getUpvotes() {
        return upvotes;
    }

    @Override
    public String toString() {
        return "Cat:" +
                "\n id=" + id +
                "\n text=" + text +
                "\n type=" + type +
                "\n user=" + user +
                "\n upvotes=" + upvotes;
    }
}