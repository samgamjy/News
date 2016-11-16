package by.vasilevich.entity;

import java.sql.Date;

public class News {
	
	private int newsID;
	private String title;
	private String shortText;
	private String fullText;
	private Date creationDate;
	private Date modificationDate;
	
	
	
	public News() {
	}

	public News(String title, String shortText, String fullText, Date creationDate, Date modificationDate) {
		this.title = title;
		this.shortText = shortText;
		this.fullText = fullText;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}

	/**
	 * @return the newsID
	 */
	public int getNewsID() {
		return newsID;
	}
	
	/**
	 * @param newsID the newsID to set
	 */
	public void setNewsID(int newsID) {
		this.newsID = newsID;
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @return the shortText
	 */
	public String getShortText() {
		return shortText;
	}
	
	/**
	 * @param shortText the shortText to set
	 */
	public void setShortText(String shortText) {
		this.shortText = shortText;
	}
	
	/**
	 * @return the fullText
	 */
	public String getFullText() {
		return fullText;
	}
	
	/**
	 * @param fullText the fullText to set
	 */
	public void setFullText(String fullText) {
		this.fullText = fullText;
	}
	
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	/**
	 * @return the modificationDate
	 */
	public Date getModificationDate() {
		return modificationDate;
	}
	
	/**
	 * @param modificationDate the modificationDate to set
	 */
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	
	
	
	

}
