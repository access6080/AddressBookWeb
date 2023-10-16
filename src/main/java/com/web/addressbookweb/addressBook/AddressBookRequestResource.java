package com.web.addressbookweb.addressBook;

import com.web.addressbookweb.buddyInfo.BuddyInfo;

import java.util.List;

public record AddressBookRequestResource(long id, List<BuddyInfo> buddies) {}
