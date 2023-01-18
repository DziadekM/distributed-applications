//This is the BMI Servlet

import java.io.*;
import java.lang.Math;

//javax 
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BMiServlet extends HttpServlet {

    /*
     * Die Methode doPost() wird vom Server (über die Service-Methode) aufgerufen,
     * damit ein Servlet eine POST-Anfrage bearbeiten kann.
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // Stream
        PrintWriter out = res.getWriter();

        // Parameter vom Formular holen für die BMI-Berechnung
        String firstname = req.getParameter("firstname");
        String height = req.getParameter("height");
        String weight = req.getParameter("weight");

        try {
            double bmi = calculateBMI(
                    Double.parseDouble(weight),
                    Double.parseDouble(height));
            double result = (int) Math.round(bmi);

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

            /*
             * Ein RequestDispatcher-Objekt kann verwendet werden, um eine Anfrage an die
             * Ressource weiterzuleiten oder um die Ressource in eine Antwort
             * einzuschließen. Die Ressource kann dynamisch oder statisch sein.
             */

        } catch (Exception e) {
            req.getRequestDispatcher("BMIErrorPage.html").forward(req, res);
        }
    }

    private Double calculateBMI(Double weight, Double height) {
        return weight / (height * height);
    }

}