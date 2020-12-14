package com.btc.rpc.entity;

import java.util.ArrayList;
import java.util.List;

public class RpcInfo {
    private List<Commands> active_commands = new ArrayList<>();
    private String logpath;

    public List<Commands> getActive_commands() {
        return active_commands;
    }

    public void setActive_commands(List<Commands> active_commands) {
        this.active_commands = active_commands;
    }

    public String getLogpath() {
        return logpath;
    }

    public void setLogpath(String logpath) {
        this.logpath = logpath;
    }
}
