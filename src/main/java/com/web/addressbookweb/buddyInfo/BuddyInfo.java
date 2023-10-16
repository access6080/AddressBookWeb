package com.web.addressbookweb.buddyInfo;

import com.web.addressbookweb.addressBook.AddressBook;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class BuddyInfo implements Serializable {
    private String name;
    private String address;
    private String phoneNumber;

    @ManyToOne
    private AddressBook addressBook;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public BuddyInfo(String name, String address, String phoneNumber, long id) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    public BuddyInfo() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuddyInfo buddyInfo = (BuddyInfo) o;
        return Objects.equals(name, buddyInfo.name) && Objects.equals(address, buddyInfo.address)
                && Objects.equals(phoneNumber, buddyInfo.phoneNumber) && Objects.equals(id, buddyInfo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, phoneNumber, id);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
         s.append("BuddyInfo{ name='")
                 .append(name).append('\'')
                 .append(", address='").append(address)
                 .append('\'').append(", phoneNumber='")
                 .append(phoneNumber).append('\'').append(", id=")
                 .append(id).append('}');

         return s.toString();
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    public static void main(String[] args) {

//        BuddyInfo homer = new BuddyInfo("Homer", "1900 Cap-wood", "123-456-7898");
//        System.out.println("Hello " + homer.getName());
    }
}
