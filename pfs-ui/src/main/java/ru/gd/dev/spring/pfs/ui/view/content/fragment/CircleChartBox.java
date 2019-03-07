package ru.gd.dev.spring.pfs.ui.view.content.fragment;

import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.html.Div;
import ru.gd.dev.spring.pfs.ui.dto.AccountDto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @autor Eremin Artem on 24.02.2019.
 */

public class CircleChartBox extends Div {

    public CircleChartBox(final List<AccountDto> accounts) {
        getClassNames().add("circleChartBox");
        getClassNames().add("accountsChartBox");
        final Map<String, BigDecimal> accountsMap = new HashMap<>();
        for (final AccountDto account : accounts) {
            accountsMap.put(account.getName(), new BigDecimal(account.getAmount().replaceAll(",", ", ")));
        }
        final ChartWithLegend chartWithLegend = new ChartWithLegend(
                ChartType.PIE,
                "Статистика по счетам",
                accountsMap
        );
        add(chartWithLegend);
    }


}
