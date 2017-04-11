package com.servlet;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveResult extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 // ���տͻ�����Ϣ	
        String assess = request.getParameter("assess");
        String result = request.getParameter("result");
        result = new String(result.getBytes("iso8859-1"),"UTF-8");
        String fileName ="F:/MyEclipse 10/Mleaf/WebRoot/temp/"+request.getParameter("fileName");
        
        File beforefile=new File(fileName);
        
        if (assess.equals("right")) {        	

        	//������Ҫ����֮����ļ������Զ���ģ���������
        	File afterfile = new File("F:/MyEclipse 10/Mleaf/WebRoot/images/"+result+"_right_"+getPhotoFileName());

        	//�����ļ���������������ȡbeforefile�ļ�
        	FileInputStream fis = new FileInputStream(beforefile);

        	//�����ļ����������������Ϣд��afterfile�ļ���
        	FileOutputStream fos = new FileOutputStream(afterfile);

        	//�ļ�������
        	byte[] b = new byte[1024];
        	//���ļ�����Ϣ��ȡ�ļ��������������ȡ�����Ϊ-1�ʹ����ļ�û�ж�ȡ��ϣ���֮�Ѿ���ȡ���
        	while(fis.read(b)!=-1){
        	//���������е�����д��afterfile�ļ���
        	fos.write(b);
        	fos.flush();
        	
        	response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print("true");
            out.flush();
            out.close();
        	}
           }
        if (assess.equals("error")) {        	

        	//������Ҫ����֮����ļ������Զ���ģ���������
        	File afterfile = new File("F:/MyEclipse 10/Mleaf/WebRoot/images/"+result+"_error_"+getPhotoFileName());

        	//�����ļ���������������ȡbeforefile�ļ�
        	FileInputStream fis = new FileInputStream(beforefile);

        	//�����ļ����������������Ϣд��afterfile�ļ���
        	FileOutputStream fos = new FileOutputStream(afterfile);

        	//�ļ�������
        	byte[] b = new byte[1024];
        	//���ļ�����Ϣ��ȡ�ļ��������������ȡ�����Ϊ-1�ʹ����ļ�û�ж�ȡ��ϣ���֮�Ѿ���ȡ���
        	while(fis.read(b)!=-1){
        	//���������е�����д��afterfile�ļ���
        	fos.write(b);
        	fos.flush();
        	
        	response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print("true");
            out.flush();
            out.close();
        	}
           }
			
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	
	 // ʹ��ϵͳ��ǰ���ڼ��Ե�����Ϊ��Ƭ������
    private String getPhotoFileName() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return sdf.format(date) + ".png";
    }

}
