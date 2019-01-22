package com.user.system.usersystem.models.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pictures")
public class Picture {
    private Integer id;
    private String title;
    private String caption;
    private String path;
    private Set<Album> albums;

    public Picture() {
        this.albums = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @ManyToMany
    @JoinTable(name = "picture_albums", joinColumns = @JoinColumn(name = "picture_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "album_id",referencedColumnName = "id"))
    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

}
