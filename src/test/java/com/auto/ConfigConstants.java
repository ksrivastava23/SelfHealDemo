package com.auto;

public class ConfigConstants {

    public static String environment="local";

    private static Boolean isLocal;

    public static Boolean getIsLocal() {
        return isLocal;
    }

    public static void setIsLocal(Boolean isLocal) {
        ConfigConstants.isLocal = isLocal;
    }
}
