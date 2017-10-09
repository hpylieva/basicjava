package neverUseSwitch;

import org.fluttercode.datafactory.impl.DataFactory;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        MailSender mailSender = new MailSender();
        DataFactory dataFactory = new DataFactory();

        while (true) {
            doWork(mailSender, dataFactory);
            Thread.sleep(1000);
        }

    }

    private static void doWork(MailSender mailSender, DataFactory dataFactory) {
        Client client = new Client(dataFactory.getName(), dataFactory.getNumberBetween(16, 32));
        MailInfo mailInfo = new MailInfo(client,dataFactory.getNumberBetween(1,4));
//        mailSender.sendMail(mailInfo);

        MailSender.CodeType codeType = MailSender.CodeType.valueOf(mailInfo.getMailCode());
        codeType.sendMail(mailInfo);
    }

}
