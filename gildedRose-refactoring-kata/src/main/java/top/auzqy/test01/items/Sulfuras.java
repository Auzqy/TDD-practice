package top.auzqy.test01.items;

import top.auzqy.test01.Item;

public class Sulfuras extends Item {
    public Sulfuras(int sellIn, int quality) {
        super("Sulfuras, Hand of Ragnaros",sellIn,quality);
    }

    @Override
    protected void updateSellInDays() {
    }

    @Override
    protected void updateQualityAfterExpiration() {
    }

    @Override
    protected void updateQuality() {
    }
}
