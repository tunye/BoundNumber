package com.ct.boundnumber;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by ct on 2015/8/19.
 */
public class Utils {
    /**
     * format
     */
    private static DecimalFormat dfs = null;

    public static DecimalFormat format(String pattern) {
        if (dfs == null) {
            dfs = new DecimalFormat();
        }
        dfs.setRoundingMode(RoundingMode.FLOOR);
        dfs.applyPattern(pattern);
        return dfs;
    }
}
