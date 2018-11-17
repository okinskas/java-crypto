package ciphers;

class TranspositionDataHolder {

    private char value;
    private StringBuilder chars;
    private long position;
    private long alphaPosition;

    public TranspositionDataHolder(char value) {
        this.value = value;
        this.chars = new StringBuilder();
    }

    public TranspositionDataHolder(char value, long position, long alphaPosition) {
        this.value = value;
        this.chars = new StringBuilder();
        this.position = position;
        this.alphaPosition = alphaPosition;
    }

    public void addChar(char c) {
        chars.append(c);
    }

    public void addString(String chars) {
        this.chars.append(chars);
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }

    public long getAlphaPosition() {
        return alphaPosition;
    }

    public void setAlphaPosition(long alphaPosition) {
        this.alphaPosition = alphaPosition;
    }

    public String getChars() {
        return chars.toString();
    }

    public void setChars(String chars) {
        this.chars = new StringBuilder(chars);
    }
}