package com.EaseItUp.careem.model.blockChain;

import java.util.Date;

/**
 * Created by ermoh on 25-02-2017.
 */
public class ChainParties {


    enum ChainPartieStatus {

        ERROR,
        SUCCESS

    }

    public BlockChain blockChain;

    public String coOwner;

    public String task;

    public Date start;

    public Date end;

    public ChainPartieStatus status;

}
