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
}
