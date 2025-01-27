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
        RightHand algorithm = new RightHand(map.getEntry(), map.getExit(), map.getMaze());
        canonicalPath = algorithm.generatePath();
    }

    public void displayCanonicalPath() {
        System.out.println("Canonical Path: " + canonicalPath);
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

        System.out.println("Factorized Path: " + factorizedPath);
    }

    public void pathChecker(String str) {
        if (str.equals(canonicalPath.toString())) {
            System.out.println("The path given is correct!");
        }
        else {
            System.out.println("The path given does not work!");
        }
    }




}
