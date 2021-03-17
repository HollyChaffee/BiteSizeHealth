package com.bytesizehealth.server.service;


import com.bytesizehealth.server.controller.ResourceNotFoundException;
import com.bytesizehealth.server.model.ByteSizeReward;
import com.bytesizehealth.server.repository.ByteSizeRewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ByteSizeRewardServiceImpl implements ByteSizeRewardService {

    @Autowired
    private ByteSizeRewardRepository rewardRepository;

    @Override
    public ByteSizeReward createByteSizeReward(ByteSizeReward byteSizeReward) {
        return rewardRepository.save(byteSizeReward);
    }

    @Override
    public ByteSizeReward updateByteSizeReward(ByteSizeReward byteSizeReward) {
        Optional<ByteSizeReward> rewardDb = this.rewardRepository.findById(byteSizeReward.getId());

        if (rewardDb.isPresent()) {
            ByteSizeReward byteSizeRewardUpdate = rewardDb.get();
            byteSizeRewardUpdate.setId(byteSizeReward.getId());
            byteSizeRewardUpdate.setName(byteSizeReward.getName());
            byteSizeRewardUpdate.setDescription(byteSizeReward.getDescription());
            rewardRepository.save(byteSizeRewardUpdate);
            return byteSizeRewardUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + byteSizeReward.getId());
        }
        //return null;
    }
    @Override
    public List<ByteSizeReward> getAllByteSizeReward() {

        return this.rewardRepository.findAll();
    }

    @Override
    public ByteSizeReward getByteSizeRewardById(long rewardId) {

        Optional<ByteSizeReward>rewardDb = this.rewardRepository.findById(rewardId);

        if (rewardDb.isPresent()) {
            return rewardDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + rewardId);
        }
    }

    @Override
    public void deleteByteSizeReward(long rewardId) {
        Optional<ByteSizeReward>rewardDb = this.rewardRepository.findById(rewardId);

        if (rewardDb.isPresent()) {
            this.rewardRepository.delete(rewardDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + rewardId);
        }

    }
}
