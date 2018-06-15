/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmdworks.recap.mail.service.builder;

import java.util.Map;

/**
 *
 * @author pradeepkm
 */
public class MailDetails {
    String to;
    Map attributes;
    String subject;
    String templatFile;

    boolean html = true;
    
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to.trim();
    }

    public Map getAttributes() {
        return attributes;
    }

    public void setAttributes(Map attributes) {
        this.attributes = attributes;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public String getTemplatFile() {
        return templatFile;
    }

    public void setTemplatFile(String templatFile) {
        this.templatFile = templatFile;
    }

    public boolean isHtml() {
        return html;
    }

    public void setHtml(boolean html) {
        this.html = html;
    }

    public MailDetails( String to, String subject, Map attrs, String templateFile )
    {
        this.to = to.trim();
        this.subject = subject;
        this.attributes = attrs;
        this.templatFile = templateFile;
    }
}
