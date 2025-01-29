package main.java.ca.mcmaster.se2aa4.mazerunner;


public class Path {
    private StringBuilder canonicalPath;
    private StringBuilder factorizedPath;
    private Maze map;

    public Path(Maze map) {
        canonicalPath = new StringBuilder();
        factorizedPath = new StringBuilder();
        this.map = map;
    }

    public void getPath() {
        RightHand algorithm = new RightHand(this.map.getEntry(), this.map.getExit(), this.map.getMaze());
        canonicalPath = algorithm.generatePath();
    }

    public void displayCanonicalPath() {
        StringBuilder formattedPath = new StringBuilder();
        int index = 0;
        
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

        for (int i = 0; i < canonicalPath.length(); i++) {
            if (canonicalPath.charAt(i) == cur) {
                count++;
            }
            else{
                factorizedPath.append(count);
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
