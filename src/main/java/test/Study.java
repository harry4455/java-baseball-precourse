package test;

public class Study {

    // 요구사항 #1
    public String[] splitTest(String word) {
        return word.split(",");
    }

    // 요구사항 #2
    public String substringTest(String word) {
        return word.substring(1, word.length()-1);
    }

    // 요구사항 #3
    public char charAtTest(String word, int idx) {
        return word.charAt(idx);
    }

}
