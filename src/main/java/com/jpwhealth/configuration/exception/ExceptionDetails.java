package com.jpwhealth.configuration.exception;

public class ExceptionDetails {

    private String title;
    private int status;
    private String detail;
    private Long timestamp;
    private String message;

    private ExceptionDetails() {
    }


    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public static final class Builder {

        private String title;
        private int status;
        private String detail;
        private Long timestamp;
        private String message;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder timestamp(Long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public ExceptionDetails build() {
            ExceptionDetails exceptionDetails = new ExceptionDetails();
            exceptionDetails.timestamp = this.timestamp;
            exceptionDetails.title = this.title;
            exceptionDetails.status = this.status;
            exceptionDetails.detail = this.detail;
            exceptionDetails.message = this.message;
            return exceptionDetails;
        }
    }
}
