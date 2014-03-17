package com.myblog.flexjson;

import org.junit.Test;

public class EasyConfSimpleTest {

    @Test
    public void testToDollars() {
        EasyConfSimple ins = new EasyConfSimple();
        System.out.println("Dollars:" + ins.toDollars(12));
    }

}
