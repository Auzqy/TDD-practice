package top.auzqy.test01.items;

import top.auzqy.test01.Item;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie",sellIn,quality);
    }

    @Override
    protected boolean isAgedBrie() {
        return true;
    }

    @Override
    protected void updateQualityAfterExpiration() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }

    @Override
    protected void updateQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }
}
