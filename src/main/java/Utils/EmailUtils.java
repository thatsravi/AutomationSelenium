package Utils;

import com.TestBase.TestBase;
import com.aventstack.extentreports.Status;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class EmailUtils  extends TestBase {

    public void sendEmailReport() throws MessagingException {

        String smtpHostServer="smtp.namm.local";
        String emailID="test@gmail.com";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host",smtpHostServer);
        Session session = Session.getInstance(properties,null);
        sendEmailReport(session,emailID,"Automation report","automation project name");
    }

    public static void sendEmailReport(Session session, String toEmail, String subject, String body) throws MessagingException {
        try {
            String fileName=System.getProperty("user.dir")+"/ExtentReports/ExtentReportResults.html";
            MimeMessage msg=new MimeMessage(session);
            msg.addHeader("Content-type","text/Html;charset=UTF-8");
            msg.addHeader("format","flowed");
            msg.addHeader("Content-Transfer-Encoding","8bit");
            msg.setFrom(new InternetAddress("test@gmail.com","NoReply-JD"));
            msg.setReplyTo(InternetAddress.parse("test@gmail.com",false));
            msg.setSubject(subject,"UTF-8");
            msg.setSentDate(new Date());
            DataSource source = (DataSource) new FileDataSource(fileName);
            msg.setDataHandler(new DataHandler((javax.activation.DataSource) source));
            msg.setFileName(fileName);
            msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(toEmail,false));
            Transport.send(msg);
            test.log(Status.INFO,"Extent report sent sucessfullly");



        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
