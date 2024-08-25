package entity;

import com.google.common.collect.ComparisonChain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Message implements Comparable<Message> {

    private String authorMessage;
    private String textMessage;
    private String dateMessage;

    public Message(String authorMessage, String textMessage, String dateMessage) {
        this.authorMessage = authorMessage;
        this.textMessage = textMessage;
        this.dateMessage = dateMessage;
    }

    public Message(String authorMessage, String textMessage) {
        this.authorMessage = authorMessage;
        this.textMessage = textMessage;
        this.dateMessage = dateGenerator();
    }

    public String getAuthorMessage() {
        return authorMessage;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public String getDateMessage() {
        return dateMessage;
    }

    private String dateGenerator() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.ITALY);
        return dateFormat.format(new Date());
    }

    @Override
    public int compareTo(Message o) {
        return ComparisonChain.start()
                .compare(Integer.parseInt(this.getDateMessage().substring(0, 4)),
                        Integer.parseInt(o.getDateMessage().substring(0, 4)))
                .compare(Integer.parseInt(this.getDateMessage().substring(5, 7)),
                        Integer.parseInt(o.getDateMessage().substring(5, 7)))
                .compare(Integer.parseInt(this.getDateMessage().substring(8, 10)),
                        Integer.parseInt(o.getDateMessage().substring(8, 10)))
                .compare(Integer.parseInt(this.getDateMessage().substring(12, 14)),
                        Integer.parseInt(o.getDateMessage().substring(12, 14)))
                .compare(Integer.parseInt(this.getDateMessage().substring(15, 17)),
                        Integer.parseInt(o.getDateMessage().substring(15, 17)))
                .result();
    }
}
