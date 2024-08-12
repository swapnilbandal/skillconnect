package com.skillconnect.controller;

import com.skillconnect.model.Bid;
import com.skillconnect.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bids")
public class BidController {

    @Autowired
    private BidService bidService;

    @GetMapping
    public List<Bid> getAllBids() {
        return bidService.getAllBids();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bid> getBidById(@PathVariable int id) {
        Optional<Bid> bid = bidService.getBidById(id);
        return bid.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Bid createBid(@RequestBody Bid bid) {
        return bidService.saveBid(bid);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bid> updateBid(@PathVariable int id, @RequestBody Bid bid) {
        if (!bidService.getBidById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        bid.setId(id);
        return ResponseEntity.ok(bidService.saveBid(bid));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBid(@PathVariable int id) {
        if (!bidService.getBidById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        bidService.deleteBid(id);
        return ResponseEntity.noContent().build();
    }
}
