package test;

import static com.company.Method.*;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import java.util.Map;

public class test_b {
    String filePath = "test.txt";
    Map<String, Map<String, Integer>> graph = genGraph(filePath);

    @Test
    public void testBridgeWordsExist() {
        // 正常情况：两个单词都有桥接词
        String result = queryBridgeWords(graph,"to", "out");
        assertEquals("The bridge from to to out are: seek.", result);
    }

    @Test
    public void testNoBridgeWords() {
        // 正常情况：两个单词没有桥接词
        String result = queryBridgeWords(graph,"to", "fits");
        assertEquals("No bridge from to to fits!", result);
    }

    @Test
    public void testWordNotInGraph() {
        // 异常情况：第一个单词不在图中
        String result = queryBridgeWords(graph,"non", "and");
        assertEquals("No non in the graph!", result);

        // 异常情况：第二个单词不在图中
        result = queryBridgeWords(graph,"to", "non");
        assertEquals("No non in the graph!", result);
    }

    @Test
    public void testBothWordsNotInGraph() {
        // 异常情况：两个单词都不在图中
        String result = queryBridgeWords(graph,"non", "ono");
        assertEquals("No non and ono in the graph!", result);
    }

    @Test
    public void testSameInputWords() {
        // 边界情况：输入单词相同
        String result = queryBridgeWords(graph,"to", "to");
        assertEquals("No bridge from to to to!", result);
    }

    @Test
    public void testEmptyInput() {
        // 边界情况：输入为空字符串
        String result = queryBridgeWords(graph,"to", "");
        assertEquals("No  in the graph!", result);

        result = queryBridgeWords(graph,"", "to");
        assertEquals("No  in the graph!", result);

        result = queryBridgeWords(graph,"", "");
        assertEquals("No  and  in the graph!", result);
    }

    @Test
    public void testSingleCharacterWords() {
        // 边界情况：输入单字符单词
        String result = queryBridgeWords(graph,"i", "t");
        assertEquals("No i and t in the graph!", result);
    }

//    @Test
//    public void testLongestWords() {
//            // 边界情况：输入最长单词
//        String longWord1 = "i".repeat(100); // 假设100为最大长度
//        String longWord2 = "t".repeat(100);
//        String result = graph.queryBridgeWords(longWord1, longWord2);
//        assertEquals("bridgeWord", result);
//    }
}
