<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="stag"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
<style>
table{
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 80%;
    }
 td,th{
    border: 3px solid #dddddd;
    text-align: left;
    padding: 8px;
    }
 </style>
 </head>
 <body style="background-color: #F0FAFE;">
 <div style="margin-top:50px; margin-left:200px; height:50px;"><h1><b>Student List</b></h1></div>
 <table style="margin-top: 0px; margin-left: 200px;">
 <tr>
    <th>Name</th>
    <th>Email</th>
    <th>MobileNumber</th>
    <th>Gender</th>
    <th>DOB</th>
    <th>College</th>
    <th>AdmissionNumber</th>
    <th>YearOfAdmission</th>
    <th>Branch</th>
    <th>Usn</th>
    <th></th>
    <th></th>
   </tr>
   <c:forEach items="${student}" var="student">
       <tr>
       <td>${student.name}</td>
       <td>${student.email}</td>
       <td>${student.mobileNumber}</td>
       <td>${student.gender}</td>
       <td>${student.dob}</td>
       <td>${student.college}</td>
       <td>${student.admissionNumber}</td>
       <td>${student.yearOfAdmission}</td>
       <td>${student.branch}</td>
       <td>${student.usn}</td>
       <td><a href="/studentManage/edit?id=${student.id}">Edit</a></td>

       <td>
       <form action="/studentManage/delete?id=${student.id}" method="post">
       <input type ="submit" value="Delete" style="background:none;border:0px;cursor: pointer;"/>
       </form>
       </td>
       </tr>
       </c:forEach>
      </table>
      <div style="margin-left: 200px;margin-top: 30px;"><a href="/studentManage/registration">Add new Student</a><div>
     </body>
   </html>

