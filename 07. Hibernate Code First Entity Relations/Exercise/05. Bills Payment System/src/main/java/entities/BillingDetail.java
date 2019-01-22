package entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BillingDetail {
    private String number;
    private User owner;

    protected BillingDetail() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @ManyToOne(optional = false,targetEntity = User.class)
    @JoinColumn(name = "owner_id",referencedColumnName = "id")
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
