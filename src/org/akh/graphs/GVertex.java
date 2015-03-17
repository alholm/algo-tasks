package org.akh.graphs;

import java.util.ArrayList;
import java.util.List;

public class GVertex {
	private int number;
	private String value;
	private List<GVertex> adjList;

	public GVertex(int number, String value) {
		this.number = number;
		this.value = value;
		this.adjList = new ArrayList<GVertex>();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<GVertex> getAdjList() {
		return adjList;
	}

	public void setAdjList(List<GVertex> adjList) {
		this.adjList = adjList;
	}

}