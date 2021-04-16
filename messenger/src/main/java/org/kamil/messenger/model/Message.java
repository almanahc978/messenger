package org.kamil.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {

	private long id;
	private String message;
	private Date cretaed;
	private String author;

	public Message() {
		
	}

	public Message(long id, String message, Date cretaed, String author) {
		super();
		this.id = id;
		this.message = message;
		this.cretaed = cretaed;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCretaed() {
		return cretaed;
	}

	public void setCretaed(Date cretaed) {
		this.cretaed = cretaed;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
