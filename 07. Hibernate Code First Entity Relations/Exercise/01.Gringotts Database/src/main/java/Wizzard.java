import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "wizard_deposits")
public class Wizzard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="first_name",length = 50)
    private String firstName;

    @Column(name ="last_name",nullable = false,length = 60)
    private String lastName;

    @Column(length = 1000)
    private String notes;

    @Column(nullable = false)
    @Check(constraints = "age >= 0")
    private int	age;

    @Column(name ="magic_wand_creator",length = 100)
    private String magicWandCreator;

    @Column(name ="magic_wand_size")
    private int magicWandSize;

    @Column(name ="deposit_group",length = 20)
    private String depositGroup;

    @Column(name ="deposit_start_date")
    private Timestamp depositStartDate;

    @Column(name ="deposit_amount")
    private BigDecimal depositAmount;

    @Column(name ="deposit_interest")
    private BigDecimal depositInterest;

    @Column(name ="deposit_charge")
    private BigDecimal depositCharge;

    @Column(name ="deposit_expiration_date")
    private Timestamp depositExpirationDate;

    @Column(name = "is_deposit_expired")
    private boolean isDepositExpired;

    public Wizzard() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMagicWandCreator() {
        return magicWandCreator;
    }

    public void setMagicWandCreator(String magicWandCreator) {
        this.magicWandCreator = magicWandCreator;
    }

    public int getMagicWandSize() {
        return magicWandSize;
    }

    public void setMagicWandSize(int magicWandSize) {
        this.magicWandSize = magicWandSize;
    }

    public String getDepositGroup() {
        return depositGroup;
    }

    public void setDepositGroup(String depositGroup) {
        this.depositGroup = depositGroup;
    }

    public Timestamp getDepositStartDate() {
        return depositStartDate;
    }

    public void setDepositStartDate(Timestamp depositStartDate) {
        this.depositStartDate = depositStartDate;
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public BigDecimal getDepositInterest() {
        return depositInterest;
    }

    public void setDepositInterest(BigDecimal depositInterest) {
        this.depositInterest = depositInterest;
    }

    public BigDecimal getDepositCharge() {
        return depositCharge;
    }

    public void setDepositCharge(BigDecimal depositCharge) {
        this.depositCharge = depositCharge;
    }

    public Timestamp getDepositExpirationDate() {
        return depositExpirationDate;
    }

    public void setDepositExpirationDate(Timestamp depositExpirationDate) {
        this.depositExpirationDate = depositExpirationDate;
    }

    public boolean isDepositExpired() {
        return isDepositExpired;
    }

    public void setDepositExpired(boolean depositExpired) {
        isDepositExpired = depositExpired;
    }
}
