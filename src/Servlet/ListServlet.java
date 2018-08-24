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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListServlet", urlPatterns = "/list")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Car> carsList = (List<Car>) session.getAttribute("cars");
        if(carsList == null) {
            carsList = new ArrayList<>();
            carsList.add(new Car("1", "Opel", "Vectra", "2008", false));
            carsList.add(new Car("2", "Opel", "Corsa", "2011", false));
            carsList.add(new Car("3", "Toyota", "Avensis", "2008", false));
            carsList.add(new Car("4", "Audi", "A4", "2008", false));
            carsList.add(new Car("5", "Volkswagen", "Golf", "2008", false));
            carsList.add(new Car("6", "Renault", "Laguna", "2008", false));
            session.setAttribute("cars", carsList);
        }
        try(PrintWriter out = resp.getWriter()){
            out.println("<h1>Wypożyczalnia samochodów</h1><table>");
            for(Car car:carsList)
            {
                out.println("<tr>");
                out.println("<td><a href=/details?id="+car.getCarID()+">"+car.getMark()+"</a></td>");
                out.println("<td>"+car.getModel()+"</td>");
                out.println("<td>"+car.getYearOfManufacture()+"</td>");
                out.println("<td>"+(car.isCarRented()?"niedostępne":"dostępne")+"</td>");
                out.println("<td><a href=/rent?id="+car.getCarID()+">Wypożycz auto</a></td>");

                out.println("</tr>");
            }
            out.println("</table>");
        }
    }
}
