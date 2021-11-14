package lesson16;

import io.appium.java_client.service.local.flags.ServerArgument;

public enum AndroidServerFlagEx implements ServerArgument {
    ALLOW_INSECURE("--allow-insecure");

    private final String arg;

    private AndroidServerFlagEx(String arg) {
        this.arg = arg;
    }

    public String getArgument() {
        return this.arg;
    }
}
