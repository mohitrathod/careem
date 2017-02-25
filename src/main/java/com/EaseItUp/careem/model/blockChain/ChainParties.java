package com.EaseItUp.careem.model.blockChain;

import java.util.Date;

/**
 * Created by ermoh on 25-02-2017.
 */
public class ChainParties {


    public enum ChainPartieStatus {

        ERROR,
        ONGOING,
        SUCCESS

    }

    public BlockChain blockChain;

    public String coOwner;

    public String task;

    public Date start;

    public Date end;

    public ChainPartieStatus status;

}
