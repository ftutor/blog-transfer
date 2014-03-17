package com.myblog.flexjson;

import com.germinus.easyconf.EasyConf;

public class EasyConfSimple {

    public static final double EURO_TO_DOLLARS_RATIO = EasyConf
            .getConfiguration("calculator").getProperties()
            .getDouble("euro-to-dollars");

    public double toDollars(double euros) {
        return euros / EURO_TO_DOLLARS_RATIO;
    }

}
