package org.rmiralles.server.base;

import javax.persistence.*;

/**
 * Created by Raul on 08/11/2015.
 */

@Entity
public class User {
    private int id;
    private String username;
    private String password;
    private String business_title;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "business_title")
    public String getBusiness_title() {
        return business_title;
    }

    public void setBusiness_title(String business_title) {
        this.business_title = business_title;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (business_title != null ? !business_title.equals(user.business_title) : user.business_title != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (business_title != null ? business_title.hashCode() : 0);
        return result;
    }
}
