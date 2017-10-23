package neverUseSwitch;

import org.fluttercode.datafactory.impl.DataFactory;

import java.util.HashMap;
import java.util.Map;

public class MailSender{

    private enum CodeType {

        WELCOME(1) {
            public void sendMail(MailInfo mailInfo) {
                System.out.println("welcome mail was generated and sent to " + mailInfo.getClient());
            }
        },
        DONTCALL(2) {
            public void sendMail(MailInfo mailInfo) {
                System.out.println("don't call us we call you. was generated and sent to " + mailInfo.getClient());
            }
        },
        THANKYOU(3) {
            public void sendMail(MailInfo mailInfo) {
                System.out.println("thank you mail is sent to " + mailInfo.getClient());
            }
        };

        public abstract void sendMail(MailInfo mailInfo);

        private int value;
        private static Map map = new HashMap<>();

        CodeType(int value) {
            this.value = value;
        }

        static {
            for (CodeType codeType : CodeType.values()) {
                map.put(codeType.value, codeType);
            }
        }

        public static CodeType valueOf(int pageType) {
            return (CodeType) map.get(pageType);
        }

        public int getValue() {
            return value;
        }


    }

    public static void doWork(MailSender mailSender, DataFactory dataFactory) {
        Client client = new Client(dataFactory.getName(), dataFactory.getNumberBetween(16, 32));
        MailInfo mailInfo = new MailInfo(client,dataFactory.getNumberBetween(1,4));
        MailSender.CodeType codeType = MailSender.CodeType.valueOf(mailInfo.getMailCode());
        codeType.sendMail(mailInfo);
    }


}
