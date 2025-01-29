package main.java.ca.mcmaster.se2aa4.mazerunner;

public class Cleaner {
    StringBuilder cleaned;

    public Cleaner() {
        cleaned = new StringBuilder();
    }

    public StringBuilder clean(String str) {

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ' ') {            /*Skips any whitespace that is encountered */
                continue;
            }

            if (Character.isDigit(ch)){
                for (int j = 0; j < (ch - '0'); j++) {
                    cleaned.append(str.charAt(i+1));        /*Appends the next letter the required amount of times */
                }
                i++;
            }
            else if (Character.isUpperCase(ch)) {
                cleaned.append(ch);             /*Appends any single character encountered */
            }
        }
        return cleaned;
    }
}
