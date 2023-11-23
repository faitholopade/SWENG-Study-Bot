package ie.tcd.scss.studybot.domain;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class PromptTo {

    private String model;
    private List<Message> messages;

    public PromptTo(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user", prompt, 0));
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Message> getMessages() {
        return this.messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}