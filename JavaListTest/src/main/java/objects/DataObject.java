package objects;

public class DataObject implements Comparable<DataObject> {
    private int currentListIndex;
    private boolean appearInMorethanOneList;
    private int count;
    private String word;

    public int getCurrentListIndex() {
        return currentListIndex;
    }

    public void setCurrentListIndex(int currentListIndex) {
        this.currentListIndex = currentListIndex;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isAppearInMorethanOneList() {
        return appearInMorethanOneList;
    }

    public void setAppearInMorethanOneList(boolean appearInMorethanOneList) {
        this.appearInMorethanOneList = appearInMorethanOneList;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public int compareTo(DataObject o) {
        return count - o.count;
    }
}