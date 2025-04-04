package main.java.ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> observers = new ArrayList<Observer>();

    public void attach(Observer observer){
        this.observers.add(observer);
    }

    public void detach(Observer observer){
        this.observers.remove(observers);
    }

    public void notifyAllObservers(){
        for (Observer observer : this.observers){
            observer.update();
        }
    }
    public abstract Position getLocation();

    public abstract Move getMove();

}
