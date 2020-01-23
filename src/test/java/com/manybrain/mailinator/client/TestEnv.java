package com.manybrain.mailinator.client;

public class TestEnv
{

    // lazy initialized variables

    private static String phoneNumber;
    private static String messageWithAttachmentId;
    private static String inboxTest;
    private static String privateDomain;
    private static Integer attachmentId;
    private static MailinatorClient client;

    // constants

    public static final String ENV_DELETE_DOMAIN = "MAILINATOR_TEST_DELETE_DOMAIN";
    public static final String ENV_API_TOKEN = "MAILINATOR_TEST_API_TOKEN";
    public static final String ENV_DOMAIN_PRIVATE = "MAILINATOR_TEST_DOMAIN_PRIVATE";
    public static final String ENV_INBOX_TEST = "MAILINATOR_TEST_INBOX";
    public static final String ENV_MESSAGE_WITH_ATTACHMENT_ID = "MAILINATOR_TEST_MESSAGE_WITH_ATTACHMENT_ID";
    public static final String ENV_ATTACHMENT_ID = "MAILINATOR_TEST_ATTACHMENT_ID";
    public static final String ENV_PHONE_NUMBER = "MAILINATOR_TEST_PHONE_NUMBER";

    // variables initialization

    public static MailinatorClient getMailinatorClient()
    {
        if (client == null)
        {
            synchronized (TestEnv.class)
            {
                if (client == null)
                {
                    client = new MailinatorClient(System.getenv(ENV_API_TOKEN));
                }
            }
        }
        return client;
    }

    public static String getPrivateDomain()
    {
        if (privateDomain == null)
        {
            synchronized (TestEnv.class)
            {
                if (privateDomain == null)
                {
                    privateDomain = System.getenv(ENV_DOMAIN_PRIVATE);
                }
            }
        }
        return privateDomain;
    }

    public static String getInboxTest()
    {
        if (inboxTest == null)
        {
            synchronized (TestEnv.class)
            {
                if (inboxTest == null)
                {
                    inboxTest = System.getenv(ENV_INBOX_TEST);
                }
            }
        }
        return inboxTest;
    }

    public static String getMessageWithAttachmentId()
    {
        if (messageWithAttachmentId == null)
        {
            synchronized (TestEnv.class)
            {
                if (messageWithAttachmentId == null)
                {
                    messageWithAttachmentId = System.getenv(ENV_MESSAGE_WITH_ATTACHMENT_ID);
                }
            }
        }
        return messageWithAttachmentId;
    }

    public static Integer getAttachmentId()
    {
        if (attachmentId == null)
        {
            synchronized (TestEnv.class)
            {
                if (attachmentId == null)
                {
                    attachmentId = Integer.valueOf(System.getenv(ENV_ATTACHMENT_ID));
                }
            }
        }
        return attachmentId;
    }

    public static String getPhoneNumber()
    {
        if (phoneNumber == null)
        {
            synchronized (TestEnv.class)
            {
                if (phoneNumber == null)
                {
                    phoneNumber = System.getenv(ENV_PHONE_NUMBER);
                }
            }
        }
        return phoneNumber;
    }
}
