package guessGame;
import javax.swing.*;

public class Communication {

    public static Integer askForInteger(String message) {
        int result;
        int dialogResult ;
        do {
            String strUserEnteredInteger = JOptionPane.showInputDialog(null, message);
            if ((strUserEnteredInteger != null) && (strUserEnteredInteger.length() > 0)) {
                try {
                    result = Integer.parseInt(strUserEnteredInteger);
                    if (result<0) throw new IllegalArgumentException();
                    return result;
                } catch (Exception e) {
                    dialogResult=JOptionPane.showConfirmDialog(null,
                            "You've entered a not valid number. Do you want to try again?", "Warning",JOptionPane.ERROR_MESSAGE);
                }

            } else {
                dialogResult=JOptionPane.showConfirmDialog(null,
                        "You have not entered anything. Do you want to try again?","Warning",JOptionPane.ERROR_MESSAGE);
            }
        }while(dialogResult == JOptionPane.YES_OPTION);

        System.exit(0);
        return 0;
    }


}
