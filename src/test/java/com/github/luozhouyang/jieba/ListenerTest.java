package com.github.luozhouyang.jieba;

import java.io.IOException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ListenerTest {

    JiebaSegmenter segmenter = new JiebaSegmenter();

    @Before
    public void setUp() throws IOException {
        System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "debug");
        segmenter.subscribe(System.out::println);
    }

    @Test
    public void test01() {

        System.out.println("origin");
        List<String> strings = segmenter.sentenceProcess("如果放到post中将出错");
        System.out.println(String.join("/", strings));
        System.out.println("split1");
        segmenter.suggestFreq(true, "中", "将");
        strings = segmenter.sentenceProcess("如果放到post中将出错");
        System.out.println(String.join("/", strings));
        System.out.println("add1");
        segmenter.suggestFreq(true, "中将");
        strings = segmenter.sentenceProcess("如果放到post中将出错");
        System.out.println(String.join("/", strings));
        System.out.println("split2");
        segmenter.suggestFreq(true, "中", "将");
        strings = segmenter.sentenceProcess("如果放到post中将出错");
        System.out.println(String.join("/", strings));
    }

    @Test
    public void test02() {
        List<String> strings = segmenter.sentenceProcess("大连美容美发学校中君意是你值得信赖的选择");
        System.out.println(String.join("/", strings));
        segmenter.suggestFreq(true, "君意");
        strings = segmenter.sentenceProcess("大连美容美发学校中君意是你值得信赖的选择");
        System.out.println(String.join("/", strings));
    }

    @Test
    public void test03() {
        List<String> strings = segmenter.sentenceProcess("大连美容美发学校中君意是你值得信赖的选择");
        System.out.println(String.join("/", strings));
        segmenter.suggestFreq(true, "美", "容");
        strings = segmenter.sentenceProcess("大连美容美发学校中君意是你值得信赖的选择");
        System.out.println(String.join("/", strings));
        strings = segmenter.sentenceProcess("美容");
        System.out.println(String.join("/", strings));
    }

    @Test
    public void test04() {
        List<String> strings = segmenter.sentenceProcess("大连美容美发学校中君意是你值得信赖的选择");
        System.out.println(String.join("/", strings));
        segmenter.delWord("美容美发");
        strings = segmenter.sentenceProcess("大连美容美发学校中君意是你值得信赖的选择");
        System.out.println(String.join("/", strings));
        strings = segmenter.sentenceProcess("美容");
        System.out.println(String.join("/", strings));
    }
}
