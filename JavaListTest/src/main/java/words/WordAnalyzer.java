package words;

import java.util.*;
import objects.DataObject;

public class WordAnalyzer {

    Map<String, DataObject> dataStore = new LinkedHashMap<>();
    private final List<List<String>> wordsListOfLists;

    public WordAnalyzer(List<List<String>> wordsListOfLists) {
        this.wordsListOfLists = wordsListOfLists;
        analyse();
    }

    private void analyse() {
        for (int index = 0; index < wordsListOfLists.size(); index++) {
            for (String word : wordsListOfLists.get(index)) {
                DataObject dataObject;
                if (dataStore.containsKey(word)) {
                    dataObject = dataStore.get(word);
                    if (dataObject.getCurrentListIndex() != index) {
                        dataObject.setAppearInMorethanOneList(true);
                    }
                    dataObject.setCount(dataObject.getCount() + 1);
                }
                else {
                    dataObject = new DataObject();
                    dataObject.setCount(1);
                    dataObject.setCurrentListIndex(index);
                    dataObject.setWord(word);
                }
                dataStore.put(word, dataObject);
            }
        }
    }

    public int uniqueWordsCount() {
        int uniqueWordSize = this.dataStore.keySet().size();
        System.out.println("Number of Unique words accross all the lists: " + uniqueWordSize);
        return uniqueWordSize;
    }

    public List<String> appearMoreThanOneList() {
        List<String> wordsList = new ArrayList<>();
        for (String word : dataStore.keySet()) {
            if (dataStore.get(word).isAppearInMorethanOneList()) {
                System.out.println(word);
                wordsList.add(word);
            }
        }
        System.out.println("Words that are appeared in more than one list: " + wordsList.toString());
        return wordsList;
    }

    public List<String> topFiveByCount() {
        List<DataObject> dataObjects = new ArrayList<>();
        List<String> top5Words = new ArrayList<>();

        for (String word : dataStore.keySet()) {
            dataObjects.add(dataStore.get(word));
        }
        Collections.sort(dataObjects, Comparator.reverseOrder());
        System.out.println("Below 5 are the top 5 words with counts");
        for (int index = 0; index < Math.min(5,dataObjects.size()); index++) {
            top5Words.add(dataObjects.get(index).getWord());
            System.out.println(dataStore.get(dataObjects.get(index).getWord()).getWord()+": "+dataStore.get(dataObjects.get(index).getWord()).getCount());
        }
        return top5Words;
    }
}
