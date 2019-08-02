package com.nativehappenings.happenings.mail;

public interface FeedbackSender {
    void sendFeedback(String from, String name, String feedback);
}
