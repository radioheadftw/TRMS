package com.revature.dao;

import com.revature.main.Attachment;

public interface AttachDAO {
	boolean createAttachment(Attachment attach);
	Attachment getAttachmentByFormId(int formid);
	Attachment getAttachmentByEid(int eid);
}
