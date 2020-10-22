package by.epam.evm.pyramid.observer;

import by.epam.evm.pyramid.model.Point;
import by.epam.evm.pyramid.model.Pyramid;

import java.util.ArrayList;
import java.util.List;

public class PyramidObservable extends Pyramid implements Observable {

    private int id;
    private List<Observer> observers = new ArrayList<>();

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.notify(this);
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setPointA(Point pointA) {
        super.setPointA(pointA);
        notifyObservers();
    }

    @Override
    public void setPointB(Point pointB) {
        super.setPointB(pointB);
        notifyObservers();
    }

    @Override
    public void setPointC(Point pointC) {
        super.setPointC(pointC);
        notifyObservers();
    }

    @Override
    public void setPointD(Point pointD) {
        super.setPointD(pointD);
        notifyObservers();
    }

    @Override
    public void setApexPoint(Point apexPoint) {
        super.setApexPoint(apexPoint);
        notifyObservers();
    }


}
