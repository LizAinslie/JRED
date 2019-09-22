package me.railrunner16.jred.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

public class FormBody {
	private List<FormBodyElement> elements;

	public FormBody() {
		this.elements = new LinkedList<>();
	}

	public void addElement(FormBodyElement element) {
		this.elements.add(element);
	}

	public void addElement(String key, String value) {
		this.addElement(new FormBodyElement(key, value));
	}

	@Getter
	@AllArgsConstructor
	public static class FormBodyElement {
		private String key;
		private String value;
	}

	@Override
	public String toString() {
		LinkedList<String> elementStrings = new LinkedList<>();

		for (FormBodyElement element : this.elements)
			elementStrings.add(element.getKey() + "=" + element.getValue());

		return String.join("&", elementStrings);
	}
}
