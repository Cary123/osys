package com.joseph.osys.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//ignore "bytes" when return json format
@JsonIgnoreProperties({"bytes"})
public class FileMeta {
	private String fileName;
	private String fileSize;
	private String fileType;
	
	private byte[] bytes;
	
	public FileMeta() {
		super();
	}

	public FileMeta(String fileName, String fileSize, String fileType,
			byte[] bytes) {
		super();
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileType = fileType;
		this.bytes = bytes;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
	
}
