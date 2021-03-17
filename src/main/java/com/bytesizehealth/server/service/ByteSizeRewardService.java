package com.bytesizehealth.server.service;

import com.bytesizehealth.server.model.ByteSizeReward;

import java.util.List;
public interface ByteSizeRewardService {
    ByteSizeReward createByteSizeReward(ByteSizeReward byteSizeReward);

    ByteSizeReward updateByteSizeReward(ByteSizeReward byteSizeReward);

    List<ByteSizeReward> getAllByteSizeReward();

    ByteSizeReward getByteSizeRewardById(long rewardId);

    void deleteByteSizeReward(long id);
}
