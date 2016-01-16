package org.rmiralles.server.base;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Raul on 08/11/2015.
 */
@Entity
public class Text {
    private int id;
    private String text;
    private String business_title;
    private Timestamp datetime;
    private String latitude;
    private String longitude;
    private User id_user;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "business_title")
    public String getBusiness_title() {
        return business_title;
    }

    public void setBusiness_title(String business_title) {
        this.business_title = business_title;
    }

    @Basic
    @Column(name = "datetime")
    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    @Basic
    @Column(name = "latitude")
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude")
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Text text1 = (Text) o;

        if (id != text1.id) return false;
        if (business_title != null ? !business_title.equals(text1.business_title) : text1.business_title != null)
            return false;
        if (datetime != null ? !datetime.equals(text1.datetime) : text1.datetime != null) return false;
        if (latitude != null ? !latitude.equals(text1.latitude) : text1.latitude != null) return false;
        if (longitude != null ? !longitude.equals(text1.longitude) : text1.longitude != null) return false;
        if (text != null ? !text.equals(text1.text) : text1.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (business_title != null ? business_title.hashCode() : 0);
        result = 31 * result + (datetime != null ? datetime.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    public User getId_user() {
        return id_user;
    }

    public void setId_user(User id_user) {
        this.id_user = id_user;
    }
}
