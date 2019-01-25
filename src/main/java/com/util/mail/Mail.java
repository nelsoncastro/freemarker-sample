package com.util.mail;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Mail {

    private String mailFrom;
    private String mailTo;
    private String mailCc;
    private String mailBcc;
    private String mailSubject;
    private String mailContent;
    private String contentType = "text/plain";
    private List<Object> attachments;

    public Mail(Builder builder) {
        this.mailFrom = builder.mailFrom;
        this.mailTo = builder.mailTo;
        this.mailSubject = builder.mailSubject;
        this.mailContent = builder.mailContent;
        this.mailCc = builder.mailCc;
        this.mailBcc = builder.mailBcc;
        this.attachments = builder.attachments;

        if (StringUtils.isNotBlank(builder.contentType))
            contentType = builder.contentType;
    }

    public static class Builder {

        // required fields
        private String mailFrom;
        private String mailTo;
        private String mailSubject;
        private String mailContent;

        // optional fields
        private String mailCc;
        private String mailBcc;
        private String contentType;
        private List<Object> attachments = new ArrayList<>();

        public Builder(String mailFrom, String mailTo, String mailSubject, String mailContent) {
            this.mailFrom = mailFrom;
            this.mailTo = mailTo;
            this.mailSubject = mailSubject;
            this.mailContent = mailContent;
        }

        public Builder withMailCc(String mailCc) {
            this.mailCc = mailCc;
            return this;
        }

        public Builder withMailBcc(String mailBcc) {
            this.mailBcc = mailBcc;
            return this;
        }

        public Builder withContentType(String contentType) {
            this.contentType = contentType;
            return this;
        }

        public Builder addAttachment(Object attachment) {
            this.attachments.add(attachment);
            return this;
        }

        public Mail build() {
            assert StringUtils.isNotEmpty(this.mailFrom);
            assert StringUtils.isNotEmpty(this.mailTo);
            assert StringUtils.isNotEmpty(this.mailSubject);
            assert StringUtils.isNotEmpty(this.mailContent);

            return new Mail(this);
        }
    }
}
