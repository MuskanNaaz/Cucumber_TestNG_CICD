package TestJAva;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TestJavaArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(5);
		list.add(2);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		System.out.println("The list of Array element: " + list.stream().sorted().collect(Collectors.toList()));
		List<Integer> data = list.stream().sorted().collect(Collectors.toList());
		List<Integer> uniqueData = new ArrayList<Integer>();
		for (int i = 1; i < data.size()-1; i++) {
			if (data.get(i) == data.get(i + 1) || data.get(i-1) == data.get(i)) {
				continue;
			}
			uniqueData.add(data.get(i));
		}

		System.out.println("output:" + uniqueData);

	}

}
