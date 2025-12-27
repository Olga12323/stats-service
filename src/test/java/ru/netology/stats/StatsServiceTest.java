package ru.netology.stats;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatsServiceTest {

    @Test
    void shouldCalculateSum() {
        StatsService service = new StatsService();
        long[] sales = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};

        long expected = 180;
        long actual = service.sumSales(sales);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateAverage() {
        StatsService service = new StatsService();
        long[] sales = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};

        long expected = 15;
        long actual = service.averageSales(sales);

        assertEquals(expected, actual);
    }

    @Test
    void shouldFindMaxSalesMonth() {
        StatsService service = new StatsService();
        long[] sales = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};

        int expected = 8; // Последний месяц с максимальными продажами (20)
        int actual = service.maxSalesMonth(sales);

        assertEquals(expected, actual);
    }

    @Test
    void shouldFindMinSalesMonth() {
        StatsService service = new StatsService();
        long[] sales = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};

        int expected = 9; // Последний месяц с минимальными продажами (7)
        int actual = service.minSalesMonth(sales);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCountMonthsBelowAverage() {
        StatsService service = new StatsService();
        long[] sales = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};

        int expected = 5; // Месяцы с продажами ниже 15
        int actual = service.monthsBelowAverage(sales);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCountMonthsAboveAverage() {
        StatsService service = new StatsService();
        long[] sales = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};

        int expected = 5; // Месяцы с продажами выше 15
        int actual = service.monthsAboveAverage(sales);

        assertEquals(expected, actual);
    }

    @Test
    void shouldWorkWithEmptyArray() {
        StatsService service = new StatsService();
        long[] sales = {};

        assertEquals(0, service.sumSales(sales));
        assertEquals(0, service.averageSales(sales));
        assertEquals(0, service.monthsBelowAverage(sales));
        assertEquals(0, service.monthsAboveAverage(sales));
    }

    @Test
    void shouldWorkWithSingleElement() {
        StatsService service = new StatsService();
        long[] sales = {100};

        assertEquals(100, service.sumSales(sales));
        assertEquals(100, service.averageSales(sales));
        assertEquals(1, service.maxSalesMonth(sales));
        assertEquals(1, service.minSalesMonth(sales));
        assertEquals(0, service.monthsBelowAverage(sales));
        assertEquals(0, service.monthsAboveAverage(sales));
    }

    @Test
    void shouldWorkWithLargeNumbers() {
        StatsService service = new StatsService();
        long[] sales = {5_000_000_000L, 3_000_000_000L, 4_000_000_000L};

        assertEquals(12_000_000_000L, service.sumSales(sales));
        assertEquals(4_000_000_000L, service.averageSales(sales));
    }
}
