package main.java.ca.mcmaster.se2aa4.mazerunner;

public class Path extends Observer{
    private StringBuilder canonicalPath;
    private StringBuilder factorizedPath;
    private Move nextMove;

    public Path(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);

        canonicalPath = new StringBuilder();
        factorizedPath = new StringBuilder();
    }

    @Override
    public void update(){
        this.nextMove = this.subject.getMove(); 

        if (this.nextMove == Move.FORWARD){
            this.canonicalPath.append("F");
        }
        else if (this.nextMove == Move.LEFT){
            this.canonicalPath.append("L");
        }
        else{
            this.canonicalPath.append("R");
        }
    }
    
    public void displayCanonicalPath() {
        StringBuilder formattedPath = new StringBuilder();
        int index = 0;
        /*Looping throught the path and adding spaces between differentc characters that are adjacent to each other */
        for (int i = 0; i < canonicalPath.length(); i++) {
            if (canonicalPath.charAt(i) == canonicalPath.charAt(index)) {
                formattedPath.append(canonicalPath.charAt(i));
            }
            else {
                formattedPath.append(' ');
                formattedPath.append(canonicalPath.charAt(i));
                index = i;
            }
        }
        System.out.println();
        System.out.println("Canonical Path: " + formattedPath);
    }

    public void displayFactorizedPath() {
        char cur = canonicalPath.charAt(0);
        int count = 0;
        /*Creates the facotized form of the canonical path */
        for (int i = 0; i < canonicalPath.length(); i++) {
            if (canonicalPath.charAt(i) == cur) {
                count++;
            }
            else{
                factorizedPath.append(count);  /*Appending the number*/
                factorizedPath.append(cur);
                factorizedPath.append(" ");
                cur = canonicalPath.charAt(i);
                count = 1;
            }
        }
        factorizedPath.append(count);
        factorizedPath.append(cur);

        System.out.println();
        System.out.println("Factorized Path: " + factorizedPath);
    }
}
