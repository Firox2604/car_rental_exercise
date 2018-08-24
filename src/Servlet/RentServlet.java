package Servlet;

import Model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/rent")
public class RentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carId = req.getParameter("id");
        HttpSession session = req.getSession();
        List<Car> cars = (List<Car>) session.getAttribute("cars");
        if (carId != null && carId.length() > 0) {
            for (Car car : cars) {
                if (car.getCarID().equals(carId)) {
                    car.setCarRented(true);
                    System.out.println("zmieniono");
                }
            }
        }
        else
        {
            resp.sendRedirect("error.jsp");
            System.out.println("Błąd");
        }
        session.setAttribute("cars",cars);
        resp.sendRedirect("index.jsp");
    }
}
