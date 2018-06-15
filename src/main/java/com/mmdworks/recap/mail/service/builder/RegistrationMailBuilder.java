package com.mmdworks.recap.mail.service.builder;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.Validate;


public class RegistrationMailBuilder {

    
    private static final String DEFAULT_SUBJECT_LINE = "Your Unique registration ID for PoD Application";
    private static final String DEFAULT_REGN_ID_TEMPLATE_FILE = "mail/regsuccessmail.ftl";
    private static final String ATTR_USER_NAME = "name";
    
    
    String name;           //attr
    String regnUniqueId;   //attr
    
    String toAddress;
    String templateFileName;
       
    public RegistrationMailBuilder toAddress(String address) {
        this.toAddress = address;
        return this;
    }
    
    public RegistrationMailBuilder withRegistrationId( String regnId ) {
        this.regnUniqueId = regnId;
        return this;
    }
    
    public RegistrationMailBuilder toName(String name) {
        this.name = name;
        return this;
    }
    
    public RegistrationMailBuilder usingTemplateFile(String templateFileName ) {
        this.templateFileName = templateFileName;
        return this;
    }
    
    public MailDetails build() {
    	
        Validate.notNull(name, "name should be mentioned for sending Registration-Unique-Id email");
        if ( templateFileName == null || templateFileName.isEmpty() ) {
            templateFileName = DEFAULT_REGN_ID_TEMPLATE_FILE;
        }
        
        Map attrs = new HashMap();
        attrs.put(ATTR_USER_NAME, name);
        

        return new MailDetails(toAddress, DEFAULT_SUBJECT_LINE, attrs, templateFileName);
    }

}
