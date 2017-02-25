package com.EaseItUp.careem.model.blockChain;

import java.util.Date;

/**
 * Created by ermoh on 25-02-2017.
 */
public class BlockChain {


    public enum BlockChainTransection {

        ARRIVED,
        IN_TRANSIT,
        DELIVERED,

    }

    public String owner;

    public BlockChainTransection blockChainTransection;

    public Date transectionStart;

    public Date transectionFinish;

}
