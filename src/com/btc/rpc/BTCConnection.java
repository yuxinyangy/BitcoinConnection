package com.btc.rpc;

import com.btc.rpc.entity.*;

public class BTCConnection {
    public static void main(String[] args) {


        BitcoinService service = new BitcoinService();
        String blockHash = service.getBestBlockHash();
        System.out.println("获取最新区块的Hash值");
        System.out.println("最新区块的hash:"+blockHash);


        String blockCount = service.getBlockCount();
        System.out.println("获取当前节点区块的总数");
        System.out.println("当前节点区块的个数:"+blockCount);


        BlockChainInfo chainInfo = service.getBlockChainInfo();
        System.out.println("获取当前节点所在链的信息");
        System.out.println("当前节点的区块数:"+chainInfo.getBlocks());
        System.out.println("当前节点的难度值:"+chainInfo.getDifficulty());


        String heightBlockHash = service.getBlockHash(Constants.HEIGHT);
        System.out.println("根据指定高度获取该高度区块的hash");
        System.out.println("第"+Constants.HEIGHT+"个区块的hash:"+heightBlockHash);


        Block block = service.getBlock(Constants.HASH0);
        System.out.println("根据区块的hash值获取区块的信息");
        System.out.println("区块的hash值:"+block.getHash());
        System.out.println("交易值:"+block.getTx());


        String address = service.getNewAddress("y",ADDRESS_TYPE.P2SH_SEGWIT);
        System.out.println("生成一个新的比特币的地址");
        System.out.println("新生成的地址:"+address);

        BlockHeader blockHeader = service.getBlockHeader(Constants.HASH0);
        System.out.println("获取指定哈希区块头");
        System.out.println("区块的hash值:"+blockHeader.getHash());


        String difficult = service.getDifficulty();
        System.out.println("获取区块难度");
        System.out.println("区块难度为:"+difficult);


        MemPoolInfo memPoolInfo = service.getMemPoolInfo();
        System.out.println("获取交易池信息");
        System.out.println("交易池大小:"+memPoolInfo.getSize());


        TxOutSetInfo txOutSetInfo = service.getTxOutSetInfo();
        System.out.println("获取交易输出集信息");
        System.out.println("最新区块hash值:"+txOutSetInfo.getBestblock());


        String verify = service.verifyChain();
        System.out.println("校验本地区块");
        System.out.println(verify);


        RpcInfo rpcInfo = service.getRpcInfo();
        System.out.println("获取RPC服务器信息");
        Commands str = rpcInfo.getActive_commands().get(0);
        System.out.println(str.getDuration());
        System.out.println("地址:"+rpcInfo.getLogpath());


        int uptime = service.upTime();
        System.out.println("获取正常运行时间为:"+uptime+"秒");


        MiningInfo miningInfo = service.getMiningInfo();
        System.out.println("获取挖矿信息");
        System.out.println("当前节点的区块数:"+miningInfo.getBlocks());

        String network = service.getNetworkHashPS(Constants.N_BLOCK,miningInfo.getBlocks());
        System.out.println("全网哈希生成速率为:"+network);


        MemoryInfo memoryInfo = service.getMemoryInfo();
        System.out.println("获取内存利用信息");
        System.out.println("已使用字节数:"+memoryInfo.getLocked().getUsed());


        DateAddress dateAddress = service.vaLiDateAddress(address);
        System.out.println("验证地址有效性");
        System.out.println("地址是否有效:"+dateAddress.isIsvalid());

    }
}
