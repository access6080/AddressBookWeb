package com.web.addressbookweb.addressBook;

import com.web.addressbookweb.buddyInfo.BuddyInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService {
    private final AddressBookRepository repo;

    public AddressBookService(AddressBookRepository repo) {
        this.repo = repo;
    }

    public List<AddressBook> getAllAddressBooks() {
        List<AddressBook> addressBooks = new ArrayList<>();
        for (AddressBook ab: repo.findAll()) {
            AddressBook a = new AddressBook(ab.getId());
            for (BuddyInfo b: ab.getBuddies()) {
                a.addBuddy(b);
            }
            addressBooks.add(a);
        }
        return addressBooks;
    }

    public void createNewAddressBook(AddressBookRequestResource addressBook) {
        AddressBook a = new AddressBook(addressBook.id());
        for(BuddyInfo b: addressBook.buddies()){
            a.addBuddy(b);
        }
        repo.save(a);
    }

    public void deleteAddressBook(Long id) {
        boolean exists = repo.existsById(id);

        if (!exists) throw new IllegalStateException("Address Book with id " + id + " does not exist.");

        repo.deleteById(id);
    }

    public void removeBuddyInfo(Long addressBookId, Long buddyInfoId) {
        AddressBook addressBook = repo.findById(addressBookId)
                .orElseThrow(() -> new IllegalStateException("Address Book with id "
                        + addressBookId + " does not exist."));

        addressBook.removeBuddyWithId(buddyInfoId);

        repo.save(addressBook);
    }

    public void addBuddyInfo(AddressBookAddBuddyResource buddyInfo) {
        AddressBook addressBook = repo.findById(buddyInfo.addressBookId())
                .orElseThrow(() -> new IllegalStateException("Address Book with id "
                        + buddyInfo.addressBookId() + " does not exist."));

        addressBook.addBuddy(buddyInfo.buddyInfo());

        repo.save(addressBook);
    }

    public AddressBook getAddressBookById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalStateException("Address Book with id "
                        + id + " does not exist."));
    }
}
