package top.auzqy.test01;

import com.google.common.base.Charsets;
import com.google.common.io.CharSource;
import com.google.common.io.Files;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;

public class GildedRoseSafetyNet {

    @Test
    void should_always_align_with_baseline() throws IOException {
        String output = TextTestFixture.getBaseLine();
        String baseline = Files.asCharSource(
                new File("src/test/java/top/auzqy/test01/baseline.txt"),
                Charsets.UTF_8).read();
        System.out.println("output = " + output);
        System.out.println("baseline = " + baseline);
        Assertions.assertEquals(output, baseline);
    }
}
