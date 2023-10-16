package com.web.addressbookweb.addressBook;
import com.web.addressbookweb.buddyInfo.BuddyInfo;
import com.web.addressbookweb.buddyInfo.BuddyInfoController;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class AddressBook implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressBook", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<BuddyInfo> book;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int size;

    public AddressBook(long id) {
        this.id  = id;
        this.size = 0;
    }

    public AddressBook()  {}

    public void addBuddy(BuddyInfo buddy) {
        if (book == null) book = new ArrayList<>();
        book.add(buddy);
        buddy.setAddressBook(this);
        this.size += 1;
    }

    public void removeBuddy(BuddyInfo buddy){
        book.remove(buddy);
    }

    public void removeBuddyWithId(Long id) {
        BuddyInfo b = null;
        for(BuddyInfo bi: book) {
            if(Objects.equals(bi.getId(), id)) b = bi;
        }

        if (b == null) return;

        this.removeBuddy(b);
    }

    public void printBuddyNames(){
        for (BuddyInfo buddy : book){
            System.out.println(buddy.toString());
        }
    }

    public void printAddressBook() {
        for (BuddyInfo record : book){
            System.out.println(record.getName() + "\n" +  record.getAddress() + "\n" + record.getPhoneNumber());
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (BuddyInfo b : this.book) {
            s.append(b.toString()).append("\n");
        }

        return "AddressBook{" +
                "book=" + s +
                ", id=" + id +
                ", size=" + size +
                '}';
    }

    public int getSize() {
        return book.size();
    }

    public List<BuddyInfo> getBuddies() {
        return book;
    }


    public static void main(String[] args) {
        AddressBook book = new AddressBook();
        BuddyInfo homer = new BuddyInfo();
        homer.setName("homer");
        homer.setAddress("1900 Cap-wood");
        homer.setPhoneNumber("123-456-7898");

        BuddyInfo george = new BuddyInfo();
        george.setName("George");
        george.setAddress("1234 Pine St");
        george.setPhoneNumber("123-496-7898");

        book.addBuddy(homer);
        book.addBuddy(george);

        book.printAddressBook();
        book.removeBuddy(homer);

        book.printBuddyNames();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
