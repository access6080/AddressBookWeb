package com.web.addressbookweb.addressBook;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {

    List<AddressBook> findBySize(int size);
    AddressBook findById(long id);
}
