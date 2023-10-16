package com.web.addressbookweb.addressBook;

import com.web.addressbookweb.buddyInfo.BuddyInfo;

public record AddressBookAddBuddyResource(Long addressBookId, BuddyInfo buddyInfo) {}
