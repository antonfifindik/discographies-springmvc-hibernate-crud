package com.antonfifindik.discographies.models;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Антон on 26.03.2018.
 */
@Entity
public class Labels {
    private long id;
    private String name;
    private String description;
    private byte[] photo;
    private Set<Albums> albums = new HashSet<Albums>();

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 5000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "photo", nullable = true)
    @Lob
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @ManyToMany
    @JoinTable(name = "albums_labels", joinColumns = @JoinColumn(name = "label_id"), inverseJoinColumns = @JoinColumn(name = "album_id"))
    public Set<Albums> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Albums> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return "Labels{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                //          ", photo=" + Arrays.toString(photo) +
                '}';
    }
}
