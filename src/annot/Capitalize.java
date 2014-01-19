package annot;

public class Capitalize {
	@MyFilter(MyFilter.Position.BEFORE)
	public String doJob(String in) {
		return in.toUpperCase();
	}

}
