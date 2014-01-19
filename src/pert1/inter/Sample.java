package pert1.inter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sample {

	public static void main(String[] args) {
		My my = new My();
		my.getList().add("2");
	}

}


final class My {

	private final List<String> list;

	public My() {
		this.list = new ArrayList<String>() {

			{
				add("0");
				add("1");
				add("2");
			}
		};

	}
	public List<String> getList() {
		return Collections.unmodifiableList(list);
	}

}