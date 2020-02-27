package com.jiker.keju;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ProjectName: my-test
 * @Author: xwy
 * @Description:
 * @Date: 2020/2/26
 * @Version: 1.0
 */
public class FileAnalysTest {

    /*测试从文件读取内容*/
    @Test
    public void test_file_content() throws NoSuchFieldException {
        List<String> fileContent = null;
        fileContent = FileAnalys.getFileContent("src/main/resources/read.txt");
        String out = "";
        for (String s : fileContent) {
            out += s ;
        }
        Assert.assertEquals("第一行第二行",out);
    }

    /*测试文件不存在*/
    @Test(expected = NoSuchFieldException.class)
    public void test_file_content_file_does_not_exit() throws NoSuchFieldException {
        List<String> fileContent = null;
        fileContent = FileAnalys.getFileContent("src/main/resources/read2.txt");
    }

    /*测试从一行中读取两位数值*/
    @Test
    public void test_get_two_numbers_from_String(){
        Pair<BigDecimal, BigDecimal> pair = FileAnalys.getJourneyAndTime("asd123tgsf567");
        Assert.assertEquals("123",pair.getLeft().toString());
        Assert.assertEquals("567",pair.getRight().toString());
    }



}