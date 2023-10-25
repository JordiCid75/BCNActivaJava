package TareaS106.N1Exercici1;

public class NoGenericMethods<T1, T2, T3> {
	T1 obj1;
	T2 obj2;
	T3 obj3;
	public T1 getObj1() {
		return obj1;
	}
	public void setObj1(T1 obj1) {
		this.obj1 = obj1;
	}
	public T2 getObj2() {
		return obj2;
	}
	public void setObj2(T2 obj2) {
		this.obj2 = obj2;
	}
	public T3 getObj3() {
		return obj3;
	}
	public void setObj3(T3 obj3) {
		this.obj3 = obj3;
	}
	public NoGenericMethods(T1 obj1, T2 obj2, T3 obj3) {
		super();
		this.obj1 = obj1;
		this.obj2 = obj2;
		this.obj3 = obj3;
	}
	

	
}
