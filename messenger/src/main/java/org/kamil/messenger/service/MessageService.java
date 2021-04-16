package org.kamil.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.kamil.messenger.database.DatabaseClass;
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

	public Message getMessage(long id) {
		return messages.get(id);
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
