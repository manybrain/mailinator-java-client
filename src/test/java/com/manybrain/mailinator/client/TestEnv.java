package com.manybrain.mailinator.client;

public class TestEnv
{

    public static final String INBOX_TEST = System.getenv("MAILINATOR_TEST_INBOX");
    public static final String PHONE_NUMBER = System.getenv("MAILINATOR_TEST_PHONE_NUMBER");
    public static final String DOMAIN_PRIVATE = System.getenv("MAILINATOR_TEST_DOMAIN_PRIVATE");
    private static final String API_TOKEN = System.getenv("MAILINATOR_TEST_API_TOKEN");
    public static final String MESSAGE_WITH_ATTACHMENT_ID = System.getenv("MAILINATOR_TEST_MESSAGE_WITH_ATTACHMENT_ID");
    public static final Integer ATTACHMENT_ID = Integer.valueOf(System.getenv("MAILINATOR_TEST_ATTACHMENT_ID"));
    public static final MailinatorClient MAILINATOR_CLIENT = new MailinatorClient(API_TOKEN);
}
