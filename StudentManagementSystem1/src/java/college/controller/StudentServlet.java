package college.controller;

import college.dao.StudentDAO;
import college.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private StudentDAO dao = new StudentDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if ("add".equalsIgnoreCase(action)) {

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String dept = request.getParameter("department");
            double cgpa = Double.parseDouble(request.getParameter("cgpa"));

            boolean ok = dao.addStudent(
                    new Student(name, email, dept, cgpa)
            );

            out.println(ok
                    ? "Student added successfully!"
                    : "Failed to add student.");

        } else if ("delete".equalsIgnoreCase(action)) {

            int id = Integer.parseInt(request.getParameter("id"));

            boolean ok = dao.deleteStudent(id);

            out.println(ok
                    ? "Student removed successfully!"
                    : "Student ID not found.");

        } else if ("update".equalsIgnoreCase(action)) {

            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String dept = request.getParameter("department");
            double cgpa = Double.parseDouble(request.getParameter("cgpa"));

            boolean ok = dao.updateStudent(
                    new Student(id, name, email, dept, cgpa)
            );

            out.println(ok
                    ? "Student updated successfully!"
                    : "Failed to update record.");

        } else {

            out.println("Invalid action.");
        }

        out.println("<br><br>");
        out.println("<a href='dashboard.html'>Back to Dashboard</a>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        List<Student> list = dao.getAllStudents();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Student List</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h1>Registered Students</h1>");

        out.println("<table border='1' cellpadding='10'>");

        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Name</th>");
        out.println("<th>Email</th>");
        out.println("<th>Department</th>");
        out.println("<th>CGPA</th>");
        out.println("</tr>");

        for (Student s : list) {

            out.println("<tr>");

            out.println("<td>" + s.getId() + "</td>");
            out.println("<td>" + s.getName() + "</td>");
            out.println("<td>" + s.getEmail() + "</td>");
            out.println("<td>" + s.getDepartment() + "</td>");
            out.println("<td>" + s.getCgpa() + "</td>");

            out.println("</tr>");
        }

        out.println("</table>");

        out.println("<br>");
        out.println("<a href='dashboard.html'>Back to Dashboard</a>");

        out.println("</body>");
        out.println("</html>");
    }
}