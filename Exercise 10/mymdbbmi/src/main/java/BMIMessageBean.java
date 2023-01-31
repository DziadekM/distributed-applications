import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jboss/exportet/jms/queue/BMIQueue"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue")
})
public class BMIMessageBean implements MessageListener {

    public BMIMessageBean() {
    };

    @Override
    public void onMessage(Message message) {
        try {
            String record = (String) message.getBody(String.class);

            File file = new File("src/main/ressources/records_mdb.csv");

            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.append(record + "\n");
            bw.close();

        } catch (JMSException ex) {
            Logger.getLogger(BMIMessageBean.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            System.out.println(ex);
        } catch (IOException ex) {
            Logger.getLogger(BMIMessageBean.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }
}
