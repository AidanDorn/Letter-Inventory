package LetterInventory;
/*
Aidan Dorn
CS 145
May 9th, 2023
 */
public class LetterInventory {
    private int size;
    private final int[] Contents;
    public LetterInventory(String input){
        //26 for the letters of the alphabet
        Contents = new int[26];
        input = input.toLowerCase();
        for (int i = 0; i < input.length(); i++){
            if (Character.isLetter(input.charAt(i))){
                Contents[input.charAt(i) - 'a']++;
                if(input.charAt(i) == 'q'){
                    Contents['u' - 'a']++;
                }
                size++;
            }
        }
    }
    public int get(char letter) {
        if (!Character.isLetter(letter))
            throw new IllegalArgumentException("letter: " + letter);
        return Contents[Character.toLowerCase(letter) - 'a'];
    }
    public void set(char letter, int value) {
        if (!Character.isLetter(letter) || value < 0)
            throw new IllegalArgumentException("letter: " + letter + ", value: " + value);
        size += value - Contents[Character.toLowerCase(letter) - 'a'];
        Contents[Character.toLowerCase(letter) - 'a'] = value;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public String toString() {
        StringBuilder output = new StringBuilder("[");
        for (int i = 0; i < 26; i++){
            output.append(String.valueOf((char) ('a' + i)).repeat(Math.max(0, Contents[i])));
        }
        return output + "]";
    }
    public LetterInventory add(LetterInventory other) {
        LetterInventory sum = new LetterInventory("");
        for (int i = 0; i < 26; i++)
            sum.Contents[i] = this.Contents[i] + other.Contents[i];
        sum.size = this.size + other.size;
        return sum;
    }
    public LetterInventory subtract(LetterInventory other) {
        LetterInventory result = new LetterInventory("");
        for (int i = 0; i < 26; i++){
            result.Contents[i] = this.Contents[i] - other.Contents[i];
            if (result.Contents[i] < 0)
                return null;
            result.size += result.Contents[i];
        }
        return result;
    }
}