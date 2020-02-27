package com.jiker.keju;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class FileAnalysTest {

    /*测试从文件读取内容*/
    @Test
    public void test_file_content() throws NoSuchFieldException, IOException {
        List<String> fileContent = null;
        fileContent = FileAnalys.getFileContent("src/main/resources/read.txt");
        String out = "";
        for (String s : fileContent) {
            out += s ;
        }
        Assert.assertEquals("第一行第二行",out);
    }

}