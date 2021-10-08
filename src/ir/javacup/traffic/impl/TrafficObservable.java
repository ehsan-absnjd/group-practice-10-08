package ir.javacup.traffic.impl;

import ir.javacup.traffic.Observable;
import ir.javacup.traffic.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class TrafficObservable <T> implements Observable<T> {
    List<Subscriber<T>> subscriberList = new ArrayList<>();


    @Override
    public void push(T obj) {
        for (Subscriber<T> subscriber : subscriberList){
            subscriber.onNext(obj);
        }

    }

    @Override
    public void subscribe(Subscriber<T> subscriber) {
        subscriberList.add(subscriber);
    }
}
