package top.auzqy.test01;

import top.auzqy.test01.items.AgedBrie;
import top.auzqy.test01.items.BackstagePass;
import top.auzqy.test01.items.Sulfuras;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public static Item createBackstagePass(int sellIn, int quality) {
        return new BackstagePass(sellIn, quality);
    }

    public static Item createSulfuras(int sellIn, int quality) {
        return new Sulfuras(sellIn, quality);
    }

    public static Item createAgedBrie(int sellIn, int quality) {
        return new AgedBrie(sellIn, quality);
    }

    /**
     * 这个方法的设计完全是为了使用时整齐，并非必须
     * @param name
     * @param sellIn
     * @param quality
     * @return
     */
    public static Item createNormalItem(String name, int sellIn, int quality) {
        return new Item(name, sellIn, quality);
    }

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

    private void updateQualityAfterExpiration() {
        if (!isAgedBrie()) {
            if (!isBackstagePass()) {
                if (quality > 0) {
                    if (!isSulfuras()) {
                        quality = quality - 1;
                    }
                }
            } else {
                quality = 0;
            }
        } else {
            if (quality < 50) {
                quality = quality + 1;
            }
        }
    }

    private boolean isExpired() {
        return sellIn < 0;
    }

    private void updateSellInDays() {
        if (!isSulfuras()) {
            sellIn = sellIn - 1;
        }
    }
}
