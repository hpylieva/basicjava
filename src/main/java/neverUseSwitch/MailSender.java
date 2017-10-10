package neverUseSwitch;

import java.util.HashMap;
import java.util.Map;

public class MailSender{

    public enum CodeType {

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

//    public void sendMail(MailInfo mailInfo) {
//        System.out.println("Hi");
//        switch (mailInfo.getMailCode()) {
//            case 1:
//                //40 lines of code
//                System.out.println("welcome mail was generated and sent to " + mailInfo.getClient());
//                break;
//            case 2:
//                //45 lines of code
//                System.out.println("don't call us we call you. was generated and sent to " + mailInfo.getClient());
//                break;
//        }
//    }

}
