package com.bytesizehealth.server.controller;

import com.bytesizehealth.server.model.ByteSizeReward;
import com.bytesizehealth.server.service.ByteSizeRewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ByteSizeRewardController {

    @Autowired
    private ByteSizeRewardService byteSizeRewardService;

    @GetMapping("/byteSizeReward")
    public ResponseEntity<List<ByteSizeReward>> getAllByteSizeReward() {
        return ResponseEntity.ok().body(byteSizeRewardService.getAllByteSizeReward());
    }

    @GetMapping("/byteSizeReward/{id}")
    public ResponseEntity<ByteSizeReward> getByteSizeRewardById(@PathVariable long id) {
        return ResponseEntity.ok().body(byteSizeRewardService.getByteSizeRewardById(id));
    }

    @PostMapping("/byteSizeReward")
    public ResponseEntity<ByteSizeReward> createByteSizeReward(@RequestBody ByteSizeReward byteSizeReward) {
        return ResponseEntity.ok().body(this.byteSizeRewardService.createByteSizeReward(byteSizeReward));
    }

    @PutMapping("/byteSizeReward/{id}")
    public ResponseEntity<ByteSizeReward> updateByteSizeReward(@PathVariable long id, @RequestBody ByteSizeReward byteSizeReward) {
        byteSizeReward.setId(id);
        return ResponseEntity.ok().body(this.byteSizeRewardService.updateByteSizeReward(byteSizeReward));
    }

    @DeleteMapping("/byteSizeReward/{id}")
    public HttpStatus deleteByteSizeReward(@PathVariable long id) {
        this.byteSizeRewardService.deleteByteSizeReward(id);
        return HttpStatus.OK;
    }
}

