package pert1;

enum Gender {
	MAN("Man", 0),
	WOMAN("Woman", 1),
	OTHER("Other", 2),
	OOO("OOO", 3);

	private String name4disp;
	private int val4db;
	private Gender(String name4disp, int val4db) {
		this.name4disp = name4disp;
		this.val4db = val4db;
	}

	public String toString() {
		return this.name4disp;
	}
	public int toDatabaseValue() {
		return this.val4db;
	}
}

public class EnumSample {

	public static void main(String[] args) {

		meth(Gender.MAN);

	}

	public static void meth(Gender gender) {
		switch (gender) {
		case MAN:
			System.out.println("he is the Man");
			break;
		case WOMAN:
		case OTHER:
			System.out.println("she is not the Man");
		default:
			assert(true);
		}
	}
}

