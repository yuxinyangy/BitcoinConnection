package com.btc.rpc.entity;

public class MiningInfo {
    private int blocks;
    private int difficulty;
    private float networkhashps;
    private int pooledtx;
    private String chain;
    private String warnings;

    public int getBlocks() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public float getNetworkhashps() {
        return networkhashps;
    }

    public void setNetworkhashps(float networkhashps) {
        this.networkhashps = networkhashps;
    }

    public int getPooledtx() {
        return pooledtx;
    }

    public void setPooledtx(int pooledtx) {
        this.pooledtx = pooledtx;
    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public String getWarnings() {
        return warnings;
    }

    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }
}
