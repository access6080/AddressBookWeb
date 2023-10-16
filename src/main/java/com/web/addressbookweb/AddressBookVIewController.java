package com.web.addressbookweb;

import com.web.addressbookweb.addressBook.AddressBook;
import com.web.addressbookweb.addressBook.AddressBookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddressBookVIewController {

    private final AddressBookService service;

    public AddressBookVIewController(AddressBookService service) {
        this.service = service;
    }

    @GetMapping
    public String showAddressBookView(Model model) {
        AddressBook a = service.getAddressBookById(1L);

        model.addAttribute("id", 1);
        model.addAttribute("buddies", a.getBuddies());
        return "addressBook";
    }
}
