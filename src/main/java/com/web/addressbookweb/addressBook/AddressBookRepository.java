package com.web.addressbookweb.addressBook;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {

    List<AddressBook> findBySize(int size);
    AddressBook findById(long id);
}
