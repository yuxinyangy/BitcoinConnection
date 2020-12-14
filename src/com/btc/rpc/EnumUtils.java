package com.btc.rpc;

import java.util.HashMap;
import java.util.Map;


enum ADDRESS_TYPE {
    LEGACY,
    P2SH_SEGWIT,
    BECH32
}


public class EnumUtils {


    public static String getAddressType(ADDRESS_TYPE address_type){
        switch (address_type){
            case LEGACY:
                return "legacy";
            case P2SH_SEGWIT:
                return "p2sh-segwit";
            case BECH32:
                return "bench32";
        }
        return null;
    }
    private static Map<ADDRESS_TYPE,String> map = new HashMap<ADDRESS_TYPE,String>();
    static {
        map.put(ADDRESS_TYPE.LEGACY,"legacy");
        map.put(ADDRESS_TYPE.P2SH_SEGWIT,"p2sh-segwit");
        map.put(ADDRESS_TYPE.BECH32,"bench32");
    }
    public static String getAddressType2(ADDRESS_TYPE type){
        return map.get(type);
    }
}
