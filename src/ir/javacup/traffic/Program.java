package ir.javacup.traffic;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import ir.javacup.traffic.impl.TrafficInfo;

public class Program {
	
	public static void main(String[] args) {
		Subscriber<TrafficInfo> subscriber1 = new Subscriber<TrafficInfo>() {
			@Override
			public void onNext(TrafficInfo obj) {
				System.out.println("#1: " + obj);
			}
		};
		Subscriber<TrafficInfo> subscriber2 = new Subscriber<TrafficInfo>() {
			@Override
			public void onNext(TrafficInfo obj) {
				System.out.println("#2: " + obj);
			}
		};


		
		Observable<TrafficInfo> observable = new ir.javacup.traffic.impl.TrafficObservable();
		Transformer<TrafficInfo, String> transformer = new ir.javacup.traffic.impl.TrafficInfoTransformer();
		
		// MTAyMDEsMDM= : 10201,03
		// MTA0NTEsMDk= : 10451,09
		List<String> inputs = Arrays.asList("MTAyMDEsMDM=","MTA0NTEsMDk=" );
		
		new ir.javacup.traffic.Context<TrafficInfo, String>()
			.observable(observable)
			.transformer(transformer)
			.subscriber(subscriber1)
			.subscriber(subscriber2)
			.run(inputs);
	}

}
