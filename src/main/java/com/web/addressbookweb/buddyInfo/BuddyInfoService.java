package com.web.addressbookweb.buddyInfo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuddyInfoService {

    private final BuddyInfoRepository repo;

    public BuddyInfoService(BuddyInfoRepository repo) {
        this.repo = repo;
    }

    public List<BuddyInfo> getBuddies() {
        return (List<BuddyInfo>) repo.findAll();
    }

    public void addNewBuddy(BuddyInfo buddyInfo) {
        repo.save(buddyInfo);
    }

    public void removeBuddy(Long id) {
        boolean exists = repo.existsById(id);
        if(!exists) throw new IllegalStateException("Student with id " + id + " does not exist");

        repo.deleteById(id);
    }
}
