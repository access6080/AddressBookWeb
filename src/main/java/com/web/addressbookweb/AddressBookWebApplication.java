package com.web.addressbookweb;

import com.web.addressbookweb.addressBook.AddressBook;
import com.web.addressbookweb.addressBook.AddressBookRepository;
import com.web.addressbookweb.buddyInfo.BuddyInfo;
import com.web.addressbookweb.buddyInfo.BuddyInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AddressBookWebApplication {
    private static final Logger log = LoggerFactory.getLogger(AddressBookWebApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AddressBookWebApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner cmdRunner(BuddyInfoRepository repository){
//        return (args) -> {
//
//
//            // save a few BuddyInfos
//            BuddyInfo homerB = new BuddyInfo("Homer", "1900 Capstone Rd", "123-456-789", 1L);
//            BuddyInfo george = new BuddyInfo("George", "1125 Aylmer Ave", "234-789-101",  2L);
//
//
//
//            repository.save(homerB);
//            repository.save(george);
//
//
//            // fetch all BudduInfos
//            log.info("BuddyInfos found with findAll():");
//            log.info("-------------------------------");
//            for (BuddyInfo buddyInfo : repository.findAll()) {
//                log.info(buddyInfo.toString());
//            }
//            log.info("");
//
//            // fetch an individual BuddyInfo by ID
//            BuddyInfo buddy = repository.findById(1L);
//            log.info("BuddyInfo found with findById(1L):");
//            log.info("--------------------------------");
//            log.info(buddy.toString());
//            log.info("");
//
//            // fetch BuddyInfo by name
//            log.info("BuddyInfo found with findByName('Homer'):");
//            log.info("--------------------------------------------");
//            repository.findByName("Homer").forEach(homer -> log.info(homer.toString()));
//
//            log.info("");
//
//
//        };
//    }

    @Bean
    public CommandLineRunner adbRunner(AddressBookRepository repository){
        return (args) -> {
            AddressBook addressBook =  new AddressBook(1L);

            BuddyInfo homerB = new BuddyInfo("Homer",
                    "1900 Capstone Rd", "123-456-789", 1L);
            BuddyInfo george = new BuddyInfo("George",
                    "1125 Aylmer Ave", "234-789-101",  2L);

            addressBook.addBuddy(homerB);
            addressBook.addBuddy(george);

            repository.save(addressBook);

            // fetch all addressBooks
            log.info("AddressBook found with findAll():");
            log.info("-------------------------------");
            for (AddressBook adb : repository.findAll()) {
                log.info(adb.toString());
            }
            log.info("");

            // fetch an individual AddressBook by ID
            AddressBook adb = repository.findById(1L);
            log.info("AddressBook found with findById(1L):");
            log.info("--------------------------------");
            log.info(adb.toString());
            log.info("");

            log.info("AddressBook found with findBySize(2):");
            log.info("--------------------------------------------");
            repository.findBySize(2).forEach(book -> log.info(book.toString()));
        };
    }

}
