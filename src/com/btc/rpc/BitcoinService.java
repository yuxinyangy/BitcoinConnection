package com.btc.rpc;

import com.alibaba.fastjson.JSON;
import com.btc.rpc.entity.*;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 该类用于封装调用比特币节点的不同的功能方法，并返回相应的结果
 */
public class BitcoinService {

    //静态代码块
    private static final Map<String, String> map = new HashMap<>();

    static {
        map.put("Encoding", "UTF-8");
        map.put("Content-Type", "application/json");
        map.put("Authorization", "Basic " + RPCUtils.base64Str(Constants.USER + ":" + Constants.PASSWORD));
    }

    //需求；1、根据指定高度获取该高度区块的hash
    public String getBlockHash(int height) {
        String json = RPCUtils.prepareJSON(Constants.GET_BLOCK_HASH, height);
        RPCResult result = RPCUtils.doPost(Constants.RPCURL, map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            return result.getData().getResult();
        }
        return null;
    }

    //2、最新区块的Hash值
    public String getBestBlockHash() {
        String json = RPCUtils.prepareJSON(Constants.GET_BEST_BLOCK_HASH);
        RPCResult result = RPCUtils.doPost(Constants.RPCURL, map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            return result.getData().getResult();
        }
        return null;
    }

    //3、区块的总数
    public String getBlockCount() {
        String json = RPCUtils.prepareJSON(Constants.GET_BLOCK_COUNT);
        RPCResult result = RPCUtils.doPost(Constants.RPCURL, map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            return result.getData().getResult();
        }
        return null;
    }


    //4、获取当前节点所在链的信息
    public BlockChainInfo getBlockChainInfo() {
        String json = RPCUtils.prepareJSON(Constants.GET_BLOCK_CHAIN_INFO);
        RPCResult result = RPCUtils.doPost(Constants.RPCURL, map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            String resultStr = result.getData().getResult();
            return JSON.parseObject(resultStr, BlockChainInfo.class);

        }
        return null;
    }

    //作业:5、根据区块的hash值获取区块的信息
    public Block getBlock(String hashcode){
        String json = RPCUtils.prepareJSON(Constants.GET_BLOCK,hashcode);
        RPCResult result = RPCUtils.doPost(Constants.RPCURL, map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            String resultStr = result.getData().getResult();
            return JSON.parseObject(resultStr,Block.class);
        }
        return null;
    }
    //需求:6、生成一个新的比特币的地址

    /**
     * 生成一个新的比特币的地址
     * @param label 标签,可以自定义指定
     * @param address_type 3个类型
     * @return 地址
     */
    public String getNewAddress(String label,ADDRESS_TYPE address_type){
        String str = EnumUtils.getAddressType(address_type);
        //1.准备一个json-rpc通信的json数据格式字符串
        String json = RPCUtils.prepareJSON(Constants.GET_NEW_ADDRESS,label,str);
        RPCResult result = RPCUtils.doPost(Constants.RPCURL,map,json);
        if (result == null){
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK){
            return result.getData().getResult();
        }
        return null;
    }







    //1、获取指定哈希区块头

    /**
     * 获取指定哈希区块头
     * @param hashcode 指定区块的hash值
     * @return 指定哈希区块头信息
     */
    public BlockHeader getBlockHeader(String hashcode){
        String json = RPCUtils.prepareJSON(Constants.GET_BLOCK_HEADER,hashcode);
        RPCResult result = RPCUtils.doPost(Constants.RPCURL, map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            String resultStr = result.getData().getResult();
            return JSON.parseObject(resultStr,BlockHeader.class);
        }
        return null;
    }

    //2、获取区块难度
    public String getDifficulty(){
        String json = RPCUtils.prepareJSON(Constants.GET_DIFFICULT);
        RPCResult result = RPCUtils.doPost(Constants.RPCURL, map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            return result.getData().getResult();
        }
        return null;
    }

    //3、获取交易池信息
    public MemPoolInfo getMemPoolInfo(){
        String json = RPCUtils.prepareJSON(Constants.GET_MEM_POOL_INFO);
        RPCResult result = RPCUtils.doPost(Constants.RPCURL, map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            String resultStr = result.getData().getResult();
            return JSON.parseObject(resultStr,MemPoolInfo.class);
        }
        return null;
    }

    //4、获取交易输出集信息
    public TxOutSetInfo getTxOutSetInfo(){
        String json = RPCUtils.prepareJSON(Constants.GET_TX_OUT_SET_INFO);
        RPCResult result = RPCUtils.doPost(Constants.RPCURL, map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            String resultStr = result.getData().getResult();
            return JSON.parseObject(resultStr,TxOutSetInfo.class);
        }
        return null;
    }

    //5、校验本地区块
    public String verifyChain(){
        String json = RPCUtils.prepareJSON(Constants.VERIFY_CHAIN);
        RPCResult result = RPCUtils.doPost(Constants.RPCURL,map,json);
        if (result == null){
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK){
            return result.getData().getResult();
        }
        return null;
    }

    //6、获取RPC服务器信息
    public RpcInfo getRpcInfo(){
        String json = RPCUtils.prepareJSON(Constants.GET_RPC_INFO);
        RPCResult result = RPCUtils.doPost(Constants.RPCURL, map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            String resultStr = result.getData().getResult();
            return JSON.parseObject(resultStr,RpcInfo.class);
        }
        return null;
    }

    //7、获取正常运行时间(秒)
    public int upTime(){
        String json = RPCUtils.prepareJSON(Constants.UPTIME);
        RPCResult result = RPCUtils.doPost(Constants.RPCURL, map, json);
        if (result == null) {
            return -1;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            return Integer.parseInt(result.getData().getResult());
        }
        return -1;
    }

    //8、获取挖矿信息
    public MiningInfo getMiningInfo(){
        String json = RPCUtils.prepareJSON(Constants.GET_MINING_INFO);
        RPCResult result = RPCUtils.doPost(Constants.RPCURL, map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            String resultStr = result.getData().getResult();
            return JSON.parseObject(resultStr,MiningInfo.class);
        }
        return null;
    }

    //9、获取全网哈希生成速率
    public String getNetworkHashPS(int nBlocks,int height){
        String json = RPCUtils.prepareJSON(Constants.GET_NET_WORK_HASH_PS,nBlocks,height);
        RPCResult result = RPCUtils.doPost(Constants.RPCURL, map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            return result.getData().getResult();
        }
        return null;
    }

    //10、获取内存利用信息
    public MemoryInfo getMemoryInfo(){
        String json = RPCUtils.prepareJSON(Constants.GET_MEMORY_INFO);
        RPCResult result = RPCUtils.doPost(Constants.RPCURL, map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            String resultStr = result.getData().getResult();
            return JSON.parseObject(resultStr,MemoryInfo.class);
        }
        return null;
    }

    //11、验证地址有效性

    /**
     * 验证地址有效性
     * @param address 地址
     * @return 地址有效性信息
     */
    public DateAddress vaLiDateAddress(String address){
        String json = RPCUtils.prepareJSON(Constants.VA_LI_DATE_ADDRESS,address);
        RPCResult result = RPCUtils.doPost(Constants.RPCURL, map, json);
        if (result == null) {
            return null;
        }
        if (result.getCode() == HttpStatus.SC_OK) {
            String resultStr = result.getData().getResult();
            return JSON.parseObject(resultStr,DateAddress.class);
        }
        return null;
    }
}
