package pert1.inter;

public class CapitalixeImpl implements MyFilter {

	@Override
	public String doJob(String in) {
		return in.toUpperCase();
	}

}
