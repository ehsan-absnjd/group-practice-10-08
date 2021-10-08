package ir.javacup.traffic;

public interface Observable<T> {
	
	void push(T obj);
	
	void subscribe(Subscriber<T> subscriber);
	
}
