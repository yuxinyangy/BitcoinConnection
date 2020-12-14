package com.btc.rpc;

/**
 * 常量类,用户名，密码，url
 */
public class Constants {
    public static final String RPCURL = "http://127.0.0.1:8332";
    public static final String USER = "user";//rpc服务的用户名
    public static final String PASSWORD = "pwd";//rpc服务的用户密码
    public static final String HASH0 = "000000000019d6689c085ae165831e934ff763ae46a2a6c172b3f1b60a8ce26f";
    public static final int HEIGHT = 0;
    public static final int N_BLOCK = -1;


    public static final String GET_BLOCK_HASH = "getblockhash";
    public static final String GET_BEST_BLOCK_HASH = "getbestblockhash";
    public static final String GET_BLOCK_COUNT = "getblockcount";
    public static final String GET_BLOCK_CHAIN_INFO = "getblockchaininfo";
    public static final String GET_BLOCK = "getblock";
    public static final String GET_NEW_ADDRESS = "getnewaddress";
    public static final String GET_BLOCK_HEADER = "getblockheader";
    public static final String GET_DIFFICULT = "getdifficulty";
    public static final String GET_MEM_POOL_INFO = "getmempoolinfo";
    public static final String GET_TX_OUT_SET_INFO = "gettxoutsetinfo";
    public static final String VERIFY_CHAIN = "verifychain";
    public static final String GET_RPC_INFO = "getrpcinfo";
    public static final String UPTIME = "uptime";
    public static final String GET_MINING_INFO = "getmininginfo";
    public static final String GET_NET_WORK_HASH_PS = "getnetworkhashps";
    public static final String GET_MEMORY_INFO = "getmemoryinfo";
    public static final String VA_LI_DATE_ADDRESS = "validateaddress";
}
