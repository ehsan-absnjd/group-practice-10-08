package ir.javacup.traffic;

public interface Subscriber<T> {
	void onNext(T obj);
}
