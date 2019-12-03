package top.auzqy.test01;

import top.auzqy.test01.items.AgedBrie;
import top.auzqy.test01.items.BackstagePass;
import top.auzqy.test01.items.Sulfuras;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    protected Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    protected boolean isBackstagePass() {
        return false;
    }

    protected boolean isAgedBrie() {
        return false;
    }

    protected boolean isSulfuras() {
        return false;
    }

    void passOneDay() {
        updateSellInDays();
        updateQuality();

        if (isExpired()) {
            updateQualityAfterExpiration();
        }
    }

    private void updateQuality() {
        if (!isAgedBrie()
                && !isBackstagePass()) {
            if (quality > 0) {
                if (!isSulfuras()) {
                    quality = quality - 1;
                }
            }
        } else {
            if (quality < 50) {
                quality = quality + 1;

                if (isBackstagePass()) {
                    if (sellIn < 10) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }

                    if (sellIn < 5) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }
                }
            }
        }
    }

    protected void updateQualityAfterExpiration() {

        if (quality > 0) {

            quality = quality - 1;
        }
    }

    private boolean isExpired() {
        return sellIn < 0;
    }

    /**
     * 把这个方法下放到子类，那么这行 return 的代码就可以删除了
     */
//    private void updateSellInDays() {
//        if (isSulfuras()) {
//            return;
//        }
//        sellIn = sellIn - 1;
//    }
    protected void updateSellInDays() {
        sellIn = sellIn - 1;
    }
}
