package shampoos.impl;

import shampoos.interfaces.Label;

import javax.persistence.*;

@Entity
@Table(name = "labels")
public class BasicLabel implements Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Basic
    private String title;

    @Basic
    private String subtitle;

    @OneToOne(mappedBy = "label",targetEntity = BasicShampoo.class,cascade = CascadeType.ALL)
    private BasicShampoo basicShampoo;

    public BasicLabel() {
    }

    public BasicLabel(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getSubtitle() {
        return subtitle;
    }

    @Override
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public BasicShampoo getBasicShampoo() {
        return basicShampoo;
    }

    public void setBasicShampoo(BasicShampoo basicShampoo) {
        this.basicShampoo = basicShampoo;
    }
}
