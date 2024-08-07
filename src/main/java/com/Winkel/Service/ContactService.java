package com.Winkel.Service;

import com.Winkel.Model.Contact;
import com.Winkel.Repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private static Logger log = LoggerFactory.getLogger(ContactService.class);

    @Autowired
    private ContactRepository contactRepository;

    public boolean saveContact(Contact contactMessage){
        boolean isSaved = true;
        try {
            contactRepository.save(contactMessage);
            log.info(contactMessage.toString());
        } catch (Exception e) {
            isSaved = false;
            log.error("Error saving contact message", e);
        }
        return isSaved;
    }
}
