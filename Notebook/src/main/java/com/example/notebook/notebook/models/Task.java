package com.example.notebook.notebook.models;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String username;
    @NotNull
    private String email;
    private String title;
    private String text;
    private String country;
    private String city;
    private Date date;
    private String format_date;

    public Task() {
    }

    public Task(String username, String email, String title, String text, String country, String city) {
        this.username = username;
        this.email = email;
        this.title = title;
        this.text = text;
        this.country = country;
        this.city = city;
        this.date = new Date();
        this.format_date = dateFormat(date);
    }

    private String dateFormat(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy H:m");
        return format.format(date);
    }
}
