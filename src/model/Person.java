package model;

import java.util.Locale;
public class Person {
    static int id_number = 1;
    String id;
    String name;
    String email;

    public Person(String name) {
        this.name = name;
    }

    public static int getId_number() {
        return id_number;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }

    // Here, im getting first char of the name and surname.
    public String twoLetter(String full_name) {
        String new_string = "";
        String[] words = full_name.split("\\s");
        new_string += words[0].charAt(0);
        new_string += words[1].charAt(0);
        return new_string.toLowerCase(Locale.ROOT);
    }
    // Method combines letters and unique number for each user.
    public String Id_Generator() {
        String new_id = "";
        String two_letters = twoLetter(this.name);
        String str_number = String.format("%04d", id_number);
        id_number += 1;
        new_id = two_letters + str_number;
        return new_id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}