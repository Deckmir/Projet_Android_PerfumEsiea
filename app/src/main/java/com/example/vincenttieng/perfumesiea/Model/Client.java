package com.example.vincenttieng.perfumesiea.Model;

public class Client {
    public String Name;
    public String Prenom;
    public String Pseudo;
    public String Password;

    public Client(String name, String prenom, String pseudo, String password) {
        Name = name;
        Prenom = prenom;
        Pseudo = pseudo;
        Password = password;
    }

    public Client(String name, String prenom, String password) {
        Name = name;
        Prenom = prenom;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        Name = Name;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getPseudo() {
        return Pseudo;
    }

    public void setPseudo(String pseudo) {
        Pseudo = pseudo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
