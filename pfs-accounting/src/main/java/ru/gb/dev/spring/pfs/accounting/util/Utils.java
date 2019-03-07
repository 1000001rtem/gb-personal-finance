package ru.gb.dev.spring.pfs.accounting.util;

import org.jetbrains.annotations.Nullable;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

public final class Utils {

    private Utils() {
    }

    public static BigDecimal getBigDecimalOfString(@Nullable final String amount) {
        if (StringUtils.isEmpty(amount)) return BigDecimal.ZERO;

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(' ');
        symbols.setDecimalSeparator('.');
        String pattern = "#,##0.0#";
        DecimalFormat format = new DecimalFormat(pattern, symbols);
        format.setParseBigDecimal(true);

        try {
            return (BigDecimal) format.parse(amount);
        } catch (ParseException e) {
            return BigDecimal.ZERO;
        }
    }

}
