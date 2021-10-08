package ir.javacup.traffic;

import ir.javacup.traffic.impl.TrafficInfo;

import java.util.List;

public class Context <T,I>{
    Observable<TrafficInfo> observable;
    Transformer<TrafficInfo, String> transformer;

    public Context<T,I> observable(Observable<TrafficInfo> observable){
        this.observable =observable;
        return this;
    }
    public Context<T,I> transformer(Transformer<TrafficInfo, String> transformer){
        this.transformer=transformer;
        return this;
    }
    public Context<T,I> subscriber(Subscriber<TrafficInfo> subscriber){
        this.observable.subscribe(subscriber);
        return this;
    }
    public void run(List<String> inputs){
        for (String input : inputs){
            observable.push(transformer.transform(input));
        }

    }


}
