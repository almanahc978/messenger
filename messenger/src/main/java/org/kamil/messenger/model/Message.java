package org.kamil.messenger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {

	private long id;
	private String message;
	private Date cretaed;
	private String author;
	private Map<Long, Comment> comments = new HashMap<>();
	private List<Link> links = new ArrayList<>();

	public List<Link> getLinks() {
		return links;
	}

	@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public Message() {

	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
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
	
	public void addLink(String url, String rel) {
		Link link = new Link();
		link.setLink(url);
		link.setRel(rel);
		
		links.add(link);
	}

}
