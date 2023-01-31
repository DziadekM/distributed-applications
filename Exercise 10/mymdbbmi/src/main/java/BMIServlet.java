import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import jakarta.annotation.Resource;

import jakarta.jms.*;
import jakarta.servlet.*;

import jakarta.servlet.http.*;
import jakarta.jms.ConnectionFactory;
//keine EJB imports, nur JMS!!!

public class BMIServlet extends HttpServlet {
    // @Resources(mappedName = "java:jboss/exported/jms/queue/BMIQueue")
    @Resource(mappedName = "java:/jms/queue/BMIQueue")
    private Queue bmiqueue;

    // doGet Method
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // Stream
        PrintWriter out = res.getWriter();

        // Parameter vom Formular holen für die BMI-Berechnung
        String firstname = req.getParameter("firstname");
        String height = req.getParameter("height");
        String weight = req.getParameter("weight");

        try {

            // weight / (height * height);
            double bmi = (Double.parseDouble(weight) / (Double.parseDouble(height) * Double.parseDouble(height)));
            System.out.println(bmi);
            double result = (int) Math.round(bmi);
            String record = "firstname: " + firstname + "height: " + height + "weight: " + weight + "bmi: " + result;

            // bind Attribute to the RequestObject
            req.setAttribute("firstname", firstname);
            req.setAttribute("bmi", bmi);
            res.setHeader("bmi", String.valueOf(result));

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ihr BMI Ergebnis</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Ihr BMI Ergebnis</h1>");
            out.println("<p>Hallo " + firstname + " ihr BMI ist " + result + "</p>");
            out.println("</body>");
            out.println("</html>");

            sendMessage(record);

        } catch (Exception e) {
            req.getRequestDispatcher("BMIErrorPage.html").forward(req, res);
        }
    }

    // END doGet Method

    private void sendMessage(String messageData) {
        InitialContext ctx = null;

        try {
            ctx = new InitialContext();
            ConnectionFactory cont = (ConnectionFactory) ctx.lookup("java:jboss/exported/jms/RemoteConnectionFactory");
            JMSContext context = cont.createContext();
            context.createProducer().send(bmiqueue, messageData);

        } catch (NamingException ex) {
            System.out.println(ex);
        }
    }

}