package com.studentManagement.model;

public enum DocumentType {
	RESUME("resume"), COLLEGE_ID("college_id"), LIBRARY_CARD("library card");
	
	private String displayName;
	
    DocumentType(String displayName) {
		this.displayName = displayName;
	}
	
	public String getDisplayName() {
		return displayName;
	}
}
