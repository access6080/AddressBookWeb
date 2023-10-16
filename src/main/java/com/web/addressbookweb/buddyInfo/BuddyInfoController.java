package com.web.addressbookweb.buddyInfo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/buddyInfo")
public class BuddyInfoController {

    private final BuddyInfoService service;

    public BuddyInfoController(BuddyInfoService service) {
        this.service = service;
    }

    @GetMapping
    public List<BuddyInfo> getBuddies() {
        return service.getBuddies();
    }

    @PostMapping
    public void addNewBuddy(@RequestBody BuddyInfo buddyInfo) {
        service.addNewBuddy(buddyInfo);
    }

    @DeleteMapping(path = "{id}")
    public void removeBuddy(@PathVariable("id") Long id) {
        service.removeBuddy(id);
    }
}
