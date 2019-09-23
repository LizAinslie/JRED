package me.railrunner16.jred.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

/**
 * A form body.
 */
public class FormBody {
	private List<FormBodyElement> elements;

	/**
	 * Create a new form body.
	 */
	public FormBody() {
		this.elements = new LinkedList<>();
	}

	/**
	 * Add an element to the form body.
	 * @param element The element to add.
	 */
	public void addElement(FormBodyElement element) {
		this.elements.add(element);
	}

	/**
	 * Add an element to the form body.
	 * @param key The key of the element to add.
	 * @param value The value of the element to add.
	 */
	public void addElement(String key, String value) {
		this.addElement(new FormBodyElement(key, value));
	}

	/**
	 * An element of a form body.
	 * @author RailRunner16
	 */
	@Getter
	@AllArgsConstructor
	public static class FormBodyElement {
		private String key;
		private String value;
	}

	/**
	 * Retrieve the form body as raw form data.
	 * @return The raw form data.
	 */
	@Override
	public String toString() {
		LinkedList<String> elementStrings = new LinkedList<>();

		for (FormBodyElement element : this.elements)
			elementStrings.add(element.getKey() + "=" + element.getValue());

		return String.join("&", elementStrings);
	}
}
