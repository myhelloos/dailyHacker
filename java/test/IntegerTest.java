public class IntegerTest {
	public static void main(String[] args) {
		Integer intA = new Integer(1652462);
		Integer intB = intA;

		++intA;

		System.out.println(intB);
		System.out.println(intA);
	}
}
