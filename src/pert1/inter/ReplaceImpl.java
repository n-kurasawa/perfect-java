package pert1.inter;

public class ReplaceImpl implements MyFilter {

	private String origStr;
	private String newStr;

	public ReplaceImpl(String origStr, String newStr) {
		this.origStr = origStr;
		this.newStr = newStr;
	}

	@Override
	public String doJob(String in) {
		return in.replaceAll(origStr, newStr);
	}

}
