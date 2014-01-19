package pert1;

class My {
	private String ps;
	My(String ps) {
		this.ps = ps;
	}

	void doit(My my) {
		System.out.println(my.ps);
	}
}

public class Main2 {

	public static void main(String[] atgs) {
		My my1 = new My("my1");
		My my2 = new My("my2");

		my1.doit(my2);
	}

}
