package Servlet;

import Model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "DetailsServlet", urlPatterns = "/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carId = req.getParameter("id");
        HttpSession session = req.getSession();
        List<Car> cars = (List<Car>) session.getAttribute("cars");
        Car myCar = null;
        if (carId != null && carId.length() > 0) {
            for (Car car : cars) {
                if (car.getCarID().equals(carId)) {
                    myCar = car;
                }
            }
        } else {
            resp.sendRedirect("error.jsp");
            System.out.println("Błąd");
        }

        try (PrintWriter out = resp.getWriter()) {
            out.println("<h1>" +myCar.getMark()+" "+ myCar.getModel() + "</h1><table>");
            out.println("<tr>");
            out.println("<td><h4>Rocznik: " + myCar.getYearOfManufacture() + "</h4></td></tr>");
            out.println("<tr><td><h4>" + (myCar.isCarRented() ? "niedostępny" : "dostepny") + "</h4></td>");

            out.println("</tr>");

            out.println("</table>");
        }

    }
}
