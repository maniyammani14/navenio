package MyJunitTests;

import org.junit.Assert;
import org.junit.Test;

import words.WordAnalyzer;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WordAnalyzerTest {

    @Test
    public void shouldHandleAllUniqueWorlds() {
        System.out.println("Test Scenario 1");
        List<List<String>> listOfLists = new ArrayList<>();
        listOfLists.add(Arrays.asList("word-1", "word-2"));
        listOfLists.add(Arrays.asList("word-11", "word-12"));
        WordAnalyzer analyzer = new WordAnalyzer(listOfLists);
        Assert.assertEquals(4, analyzer.uniqueWordsCount());
        Assert.assertEquals(Collections.emptyList(), analyzer.appearMoreThanOneList());
        Assert.assertEquals(Arrays.asList("word-1", "word-2", "word-11", "word-12"), analyzer.topFiveByCount());
    }

    @Test
    public void testUniqueWords() {
        System.out.println("Test Scenario 2");
        List<List<String>> listOfLists = new ArrayList<>();
        listOfLists.add(Arrays.asList("word-1", "word-2", "word-3", "word-4", "word-5"));
        listOfLists.add(Arrays.asList("word-1", "word-2", "word-3", "word-4", "word-7"));
        listOfLists.add(new ArrayList<>());
        WordAnalyzer analyzer = new WordAnalyzer(listOfLists);
        Assert.assertEquals(6, analyzer.uniqueWordsCount());
        Assert.assertEquals("[word-1, word-2, word-3, word-4]", analyzer.appearMoreThanOneList().toString());
        Assert.assertEquals("[word-1, word-2, word-3, word-4, word-5]", analyzer.topFiveByCount().toString());
    }
}