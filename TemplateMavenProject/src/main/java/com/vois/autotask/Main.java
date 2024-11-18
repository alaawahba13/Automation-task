package com.vois.autotask;


import com.vois.autotask.datacleaning.CalculateYears;
import com.vois.autotask.datacleaning.SorterAndDeduplicator;
import com.vois.autotask.datadelivery.Email;

public class Main {

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        // First Task
       CalculateYears.calculateYears(projectPath+"\\data\\TaskData.xlsx");
        // Second Task

        SorterAndDeduplicator sorterAndDeduplicator = new SorterAndDeduplicator();
        sorterAndDeduplicator.openExcelFile(projectPath + "\\data\\ModifiedData.xlsx");
        sorterAndDeduplicator.sortByDate();
        sorterAndDeduplicator.removeDuplicatesByName();
        sorterAndDeduplicator.saveExcelFile();
        // Third Task

        String body = "Hello,\n\nThis is Alaa Emad Abd El-Hamid Wahba and I'm executing the last task." +
                "\nPlease note that this is sent from outlook and this isn't my primary email." +
                "\nThe modified excel sheet is attached below" +
                "\nI'm looking forward to hearing your feedback." +
                "\n\n Best Regards,\nAlaa Wahba.";

        Email email = new Email();
        email.setUp();
        email.setBody(body);
        email.setSubject("Automation Hiring Task");
        email.setRecipientMail("islam.hassan@vodafone.com");
        email.setAttachmentFilePath(projectPath + "\\data\\ModifiedData.xlsx");
        email.sendNewEmail();
        email.tearDown();
    }
}
