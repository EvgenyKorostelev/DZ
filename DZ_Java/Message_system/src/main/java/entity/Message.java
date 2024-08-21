package entity;

import com.google.common.collect.ComparisonChain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Message  implements Comparable<Message> {

    private String userLogin;
    private String textMessage;
    private String date;

    public Message(String userLogin, String textMessage, String date) {
        this.userLogin = userLogin;
        this.textMessage = textMessage;
        this.date = date;
    }

    public Message(String userLogin, String textMessage) {
        this.userLogin = userLogin;
        this.textMessage = textMessage;
        this.date = dateGenerator();
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public String getDate() {
        return date;
    }

    private String dateGenerator() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.ITALY);
        return dateFormat.format(new Date());
    }
    @Override
    public int compareTo(Message o) {
        return ComparisonChain.start()
                .compare(Integer.parseInt(this.getDate().substring(0, 4)),
                        Integer.parseInt(o.getDate().substring(0, 4)))
                .compare(Integer.parseInt(this.getDate().substring(5, 7)),
                        Integer.parseInt(o.getDate().substring(5, 7)))
                .compare(Integer.parseInt(this.getDate().substring(8, 10)),
                        Integer.parseInt(o.getDate().substring(8, 10)))
                .compare(Integer.parseInt(this.getDate().substring(12, 14)),
                        Integer.parseInt(o.getDate().substring(12, 14)))
                .compare(Integer.parseInt(this.getDate().substring(15, 17)),
                        Integer.parseInt(o.getDate().substring(15, 17)))
                .result();
    }
}
