package top.auzqy.test01;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

class ItemTest {

    @Test
    void should_double_increase_backstage_pass_value_when_getting_close_to_expiration() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20);
        item.passOneDay();
        MatcherAssert.assertThat(item.quality, Is.is(21));
        item.passOneDay();
        MatcherAssert.assertThat(item.quality, Is.is(23));
    }
}