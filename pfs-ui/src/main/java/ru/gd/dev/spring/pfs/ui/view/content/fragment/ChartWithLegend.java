package ru.gd.dev.spring.pfs.ui.view.content.fragment;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.Configuration;
import com.vaadin.flow.component.charts.model.Cursor;
import com.vaadin.flow.component.charts.model.DataSeries;
import com.vaadin.flow.component.charts.model.DataSeriesItem;
import com.vaadin.flow.component.charts.model.PlotOptionsPie;
import com.vaadin.flow.component.charts.model.Tooltip;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @autor Eremin Artem on 24.02.2019.
 */

public class ChartWithLegend extends Chart {

    public ChartWithLegend(@Nullable final ChartType type,
                           @Nullable final String title,
                           @Nullable final Map<String, BigDecimal> values) {
        if (type == null || title == null || title.isEmpty() || values == null) return;
        this.getConfiguration().getChart().setType(type);
        Configuration conf = getConfiguration();

        conf.setTitle(title);

        Tooltip tooltip = new Tooltip();
        tooltip.setValueDecimals(1);
        tooltip.setPointFormat("{series.name}: <b>{point.percentage}%</b>");
        conf.setTooltip(tooltip);

        PlotOptionsPie plotOptions = new PlotOptionsPie();
        plotOptions.setAllowPointSelect(true);
        plotOptions.setCursor(Cursor.POINTER);
        plotOptions.setShowInLegend(true);
        conf.setPlotOptions(plotOptions);

        DataSeries series = new DataSeries();
        for (Map.Entry<String, BigDecimal> item : values.entrySet()) {
            series.add(new DataSeriesItem(item.getKey(), item.getValue()));
        }

        if (!values.isEmpty()) {
            series.get(0).setSliced(true);
            series.get(0).setSelected(true);
        }

        conf.setSeries(series);
        setVisibilityTogglingDisabled(true);

        addPointLegendItemClickListener(event -> {
            showNotification("Legend item click" + " : " + event.getItemIndex()
                    + " : " + event.getItem().getName());
        });
    }

    private void showNotification(String message) {
        UI.getCurrent().getPage()
                .executeJavaScript("window.alert($0);", message);
    }
}
