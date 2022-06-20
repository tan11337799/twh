package com.twhupup.fruit.servlets;

import com.twhupup.config.SpringConfig;
import com.twhupup.fruit.dao.FruitDAO;
import com.twhupup.fruit.dao.FruitDAOImpl;
import com.twhupup.fruit.pojo.Fruit;
import com.twhupup.fruit.service.FruitService;
import com.twhupup.myssm.myspringmvc.ViewBaseServlet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add.do")
public class AddServlet extends ViewBaseServlet {

    private FruitDAO fruitDAO = new FruitDAOImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        FruitService fruitService = context.getBean("fruitService", FruitService.class);
        request.setCharacterEncoding("UTF-8");

        String fname = request.getParameter("fname");
        Integer price = Integer.parseInt(request.getParameter("price")) ;
        Integer fcount = Integer.parseInt(request.getParameter("fcount"));
        String remark = request.getParameter("remark");

        Fruit fruit = new Fruit(0,fname , price , fcount , remark ) ;

        fruitService.addFruit(fruit);

        response.sendRedirect("index");

    }
}