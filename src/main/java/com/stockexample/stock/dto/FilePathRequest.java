package com.stockexample.stock.dto;

public class FilePathRequest {

	private String importPath;

	private String exportPath;

	/**
	 * 
	 */
	public FilePathRequest() {
		super();
	}

	/**
	 * @param importPath
	 * @param exportPath
	 */
	public FilePathRequest(String importPath, String exportPath) {
		super();
		this.importPath = importPath;
		this.exportPath = exportPath;
	}

	/**
	 * @return the importPath
	 */
	public String getImportPath() {
		return importPath;
	}

	/**
	 * @param importPath the importPath to set
	 */
	public void setImportPath(String importPath) {
		this.importPath = importPath;
	}

	/**
	 * @return the exportPath
	 */
	public String getExportPath() {
		return exportPath;
	}

	/**
	 * @param exportPath the exportPath to set
	 */
	public void setExportPath(String exportPath) {
		this.exportPath = exportPath;
	}

}