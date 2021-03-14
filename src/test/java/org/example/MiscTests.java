package org.example;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MiscTests {

    @Test
    public void testDownload() throws IOException {
        URL url = new URL("https://pastebin.com/raw/J6ZeMquJ");
        InputStream in = url.openStream();
        String str = IOUtils.toString(in, "UTF-8");
        Assert.assertEquals("hello world", str);
    }
}
