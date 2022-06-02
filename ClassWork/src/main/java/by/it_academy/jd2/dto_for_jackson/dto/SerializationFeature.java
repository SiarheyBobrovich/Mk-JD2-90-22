package by.it_academy.jd2.dto_for_jackson.dto;

import com.fasterxml.jackson.databind.cfg.ConfigFeature;

public class SerializationFeature implements ConfigFeature {
    @Override
    public boolean enabledByDefault() {
        return false;
    }

    @Override
    public int getMask() {
        return 0;
    }

    @Override
    public boolean enabledIn(int flags) {
        return false;
    }
}
