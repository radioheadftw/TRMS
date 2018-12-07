package com.revature.services;

import com.revature.dao.AttachO;
import com.revature.main.Attachment;

public class AttachService {
	AttachO attachDao = new AttachO();
	
	public boolean createAttachment(Attachment attach) {
		return attachDao.createAttachment(attach);
	}
}
