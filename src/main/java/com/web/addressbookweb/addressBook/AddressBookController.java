package com.web.addressbookweb.addressBook;

import com.web.addressbookweb.buddyInfo.BuddyInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addressBook")
public class AddressBookController {

    private final AddressBookService service;

    public AddressBookController(AddressBookService service) {
        this.service = service;
    }

    @GetMapping
    public List<AddressBook> getAllAddressBooks() {
        return service.getAllAddressBooks();
    }

    @PostMapping
    public void createNewAddressBook(@RequestBody AddressBookRequestResource addressBook) {
        service.createNewAddressBook(addressBook);
    }

    @DeleteMapping(path = "{addressBookId}")
    public void deleteAddressBook(@PathVariable("addressBookId") Long id) {
        service.deleteAddressBook(id);
    }

    @DeleteMapping(path = "{addressBookId}/{buddyInfoId}")
    public void removeBuddyInfo(@PathVariable("addressBookId") Long addressBookId,
                                @PathVariable("buddyInfoId") Long buddyInfoId) {
        service.removeBuddyInfo(addressBookId, buddyInfoId);
    }

    @PatchMapping
    public void addBuddyInfo(@RequestBody AddressBookAddBuddyResource buddyInfo) {
        service.addBuddyInfo(buddyInfo);
    }
}
