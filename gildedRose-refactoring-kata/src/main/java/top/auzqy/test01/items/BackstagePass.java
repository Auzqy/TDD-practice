package top.auzqy.test01.items;

import top.auzqy.test01.Item;


public class BackstagePass extends Item {
    public BackstagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    protected boolean isBackstagePass() {
        return true;
    }

    @Override
    protected void updateQualityAfterExpiration() {
        quality = 0;
    }

    @Override
    protected void updateQuality() {
        if (quality < 50) {
            quality = quality + 1;

            if (sellIn >= 10) {
                return;
            }

            if (quality < 50) {
                quality = quality + 1;
            }

            if (sellIn >= 5) {
                return;
            }
            if (quality < 50) {
                quality = quality + 1;
            }
        }
    }
}
