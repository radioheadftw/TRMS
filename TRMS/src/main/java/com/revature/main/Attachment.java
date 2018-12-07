package com.revature.main;

public class Attachment {
	private int aId;
	private String filename;
	private int eid;
	private int formid;
	private byte[] document;
	
	public Attachment() {
	}

	public Attachment(int aId, String filename, byte[] document, int eid, int formid) {
		super();
		this.aId = aId;
		this.filename = filename;
		this.document = document;
		this.eid = eid;
		this.formid = formid;
	}

	public Attachment(String filename, byte[] document, int eid, int formid) {
		super();
		this.filename = filename;
		this.document = document;
		this.eid = eid;
		this.formid = formid;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public int getFormid() {
		return formid;
	}

	public void setFormid(int formid) {
		this.formid = formid;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public byte[] getDocument() {
		return document;
	}

	public void setDocument(byte[] document) {
		this.document = document;
	}
	
}
