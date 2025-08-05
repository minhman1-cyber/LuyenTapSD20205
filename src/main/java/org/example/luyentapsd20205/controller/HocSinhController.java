package org.example.luyentapsd20205.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import netscape.javascript.JSObject;
import org.example.luyentapsd20205.model.HocSinh;
import org.example.luyentapsd20205.model.TruongHoc;
import org.example.luyentapsd20205.service.HocSinhService;
import org.example.luyentapsd20205.service.TruongHocService;
import org.json.JSONObject;

import java.awt.desktop.PreferencesEvent;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HocSinhController", value = {
        "/hocsinh",
        "/hocsinh/dang-nhap",
        "/hocsinh/hien-thi",
        "/hocsinh/sua",
        "/hocsinh/xoa",
        "/hocsinh/viewSua",
        "/hocsinh/them",
        "/hocsinh/searching",
        "/hocsinh/phanTrang",
        "/hocsinh/dang-nhap1"

})
public class HocSinhController extends HttpServlet {

    HocSinhService hocSinhService = new HocSinhService();
    TruongHocService truongHocService = new TruongHocService();

    private Boolean isAdminn = null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        switch (path) {
            case "/hocsinh/hien-thi":
                hienThi(request, response);
                break;
            case "/hocsinh/xoa":
                xoa(request, response);
                break;
            case "/hocsinh/viewSua":
                viewSua(request, response);
                break;
            case "/hocsinh/phanTrang":
                phanTrang(request, response);
                break;
            case "/hocsinh/searching":
                searching(request, response);
                break;
            case "/hocsinh":
                formDangnhap(request, response);
                break;
        }

    }

    private void formDangnhap(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("xacThuc", true);
        request.getRequestDispatcher("/view/dangNhap.jsp").forward(request, response);
    }

    private void searching(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer tuoi = Integer.parseInt(request.getParameter("tuoiSearch"));
        List<HocSinh> hsList = hocSinhService.searching(tuoi);
        request.setAttribute("hsList", hsList);
        List<TruongHoc> thList = truongHocService.getAllTruongHoc();
        request.setAttribute("thList", thList);
        request.getRequestDispatcher("/view/HocSinhList.jsp").forward(request, response);
    }

    private void phanTrang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 0;
        int pageSize = 3;
        String pageParam = request.getParameter("page");
        if(pageParam != null && !pageParam.isEmpty()) {
            page = Integer.parseInt(pageParam);
        }

        request.setAttribute("page", page);
        request.setAttribute("hsList", hocSinhService.phanTrang(page, pageSize));
        List<TruongHoc> thList = truongHocService.getAllTruongHoc();
        request.setAttribute("thList", thList);
        request.getRequestDispatcher("/view/HocSinhList.jsp").forward(request, response);
    }

    private void xoa(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        hocSinhService.xoa(id);
        response.sendRedirect("/hocsinh/hien-thi");
    }

    private void viewSua(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("hs", hocSinhService.getHocSinhById(id));
        List<TruongHoc> thList = truongHocService.getAllTruongHoc();
        request.setAttribute("thList", thList);
        request.getRequestDispatcher("/view/viewSua.jsp").forward(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        List<HocSinh> hsList = hocSinhService.phanTrang(1, 3);
        request.setAttribute("hsList", hsList);
        List<TruongHoc> thList = truongHocService.getAllTruongHoc();
        request.setAttribute("isAdmin", isAdminn);
        request.setAttribute("thList", thList);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/view/HocSinhList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        switch (path) {
            case "/hocsinh/them":
                them(request, response);
                break;
            case "/hocsinh/sua":
                sua(request, response);
                break;
            case "/hocsinh/dang-nhap":
                dangNhap(request, response);
                break;
            case "/hocsinh/dang-nhap1":
                dangNhap1(request, response);
                break;
        }
    }

    private void dangNhap(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Boolean xacThuc = hocSinhService.xacThuc(username, password);
        if(xacThuc) {
            isAdminn = hocSinhService.isAdminn(username, password);
            response.sendRedirect("/hocsinh/hien-thi");
        }else{
            request.setAttribute("xacThuc", false);
            request.getRequestDispatcher("/view/dangNhap.jsp").forward(request, response);

        }
        JSONObject json = new JSONObject();
        json.put("username", username);
        json.put("password", password);

        response.setContentType("application/json");
        response.getWriter().write(json.toString());
    }

    private void dangNhap1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Boolean xacThuc = hocSinhService.xacThuc(username, password);

        JSONObject json = new JSONObject();
        response.setContentType("application/json");

        if (xacThuc) {
            isAdminn = hocSinhService.isAdminn(username, password);
            // Set session
            HttpSession session = request.getSession();
            session.setAttribute("user", username); // hoặc đối tượng tài khoản

            json.put("success", true);
            json.put("redirect", "/hocsinh/hien-thi");
        } else {
            json.put("success", false);
            json.put("message", "Tài khoản hoặc mật khẩu không đúng!");
        }

        response.getWriter().write(json.toString());
    }


    private void sua(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String ten = request.getParameter("ten");
        Integer tuoi = Integer.parseInt(request.getParameter("tuoi"));
        String tth = request.getParameter("tth");
        Boolean tthBool = "1".equals(tth);
        Integer idTruonghoc = Integer.parseInt(request.getParameter("thL"));
        hocSinhService.sua(new HocSinh(id, ten, tuoi, tthBool, truongHocService.getTruongHocById(idTruonghoc)));
        response.sendRedirect("/hocsinh/hien-thi");
    }

    private void them(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ten = request.getParameter("ten");
        Integer tuoi = Integer.parseInt(request.getParameter("tuoi"));
        String tth = request.getParameter("tth");
        Boolean tthBool = "1".equals(tth);
        Integer idTruonghoc = Integer.parseInt(request.getParameter("thL"));
        hocSinhService.them(new HocSinh(0, ten, tuoi, tthBool, truongHocService.getTruongHocById(idTruonghoc)));
        response.sendRedirect("/hocsinh/hien-thi");
    }


}