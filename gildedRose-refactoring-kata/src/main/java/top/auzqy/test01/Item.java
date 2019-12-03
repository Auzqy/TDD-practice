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

    void passOneDay() {
        updateSellInDays();
        updateQuality();

        if (isExpired()) {
            updateQualityAfterExpiration();
        }
    }

    protected void updateQuality() {
        decreaseQuality();
    }

    protected void updateQualityAfterExpiration() {
        decreaseQuality();
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

    protected void increaseQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }

    private void decreaseQuality() {
        if (quality > 0) {
            quality = quality - 1;
        }
    }

    private boolean isExpired() {
        return sellIn < 0;
    }


}
