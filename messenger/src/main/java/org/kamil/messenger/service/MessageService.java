package org.kamil.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.kamil.messenger.database.DatabaseClass;
import org.kamil.messenger.exception.DataNotFoundException;
import org.kamil.messenger.model.Message;

public class MessageService {
	
	public MessageService() {
		messages.put(1L, new Message(1L, "Hello World!", new Date(), "Kamil"));
		messages.put(2L, new Message(2L, "Hello Jersey!", new Date(), "Kamil"));
	}

	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}
	
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		
		for(Message message : messages.values()) {
			calendar.setTime(message.getCretaed());
			if(calendar.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if(start + size > list.size()) {
			return new ArrayList<Message>();
		}
		return list.subList(start, start + size);
	}

	public Message getMessage(long id) {
		Message message =  messages.get(id);
		
		if(message == null) {
			throw new DataNotFoundException("The message with ID "+ id + " does not exists");
		}
		
		return message;
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId()<=0) {
			return null;
		}
		messages.replace(message.getId(), message);
		return message;
	}
	
	public void removeMessage(long id) {
		messages.remove(id);
	}

}
