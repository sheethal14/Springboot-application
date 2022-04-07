<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration</title>
<style>
td,th{
    font-family: arial, sans-serif;
    }
    .error{
    color: red;
    font-style: italic;
    }
  </style>
 </head>
 <body style="background-color: #F0FAFE;">
 <div style="margin-top:50px; margin-left:200px; height:50px;"><h2>Student <c:out value="${student.id != null ? 'Update' : 'Registration' }"/></h2></div>
<form:form method="POST" modelAttribute="student" action="/studentManage/home" name="student">
<table style="vertical-align: center; margin-left :20%;">
        <tr>
            <td><form:hidden path="id" /></td>
        </tr>
        <tr>
            <td>Name: </td>
            <td><form:input path="name" /> </td>
            <td><form:errors path="name" cssClass="error"/> </td>
        </tr>
        <tr></tr>
        <tr></tr>
        <tr>
            <td>Email: </td>
            <td><form:input path="email" /> </td>
            <td><form:errors path="email" cssClass="error"/> </td>
        </tr>
        <tr></tr>
        <tr></tr>
        <tr>
            <td>MobileNumber: </td>
            <td><form:input path="mobileNumber" /> </td>
            <td><form:errors path="mobileNumber" cssClass="error"/> </td>
        </tr>
        <tr></tr>
        <tr></tr>
        <tr>
              <td>Gender: </td>
              <td><form:input path="gender"/> </td>
              <td><form:errors path="gender" cssClass="error"/> </td>
        </tr>
        <tr></tr>
        <tr></tr>
         <tr>
            <td>DOB: </td>
            <td><form:input path="dob" /> </td>
            <td><form:errors path="dob" cssClass="error"/> </td>
        </tr>
        <tr></tr>
        <tr></tr>
        <tr>
             <td>College: </td>
             <td><form:input path="college" /> </td>
             <td><form:errors path="college" cssClass="error"/> </td>
         </tr>
         <tr></tr>
         <tr></tr>
        <tr>
            <td>AdmissionNumber: </td>
            <td><form:input path="admissionNumber" /></td>
        </tr>
        <tr></tr>
        <tr></tr>
         <tr>
             <td>YearOfAdmission: </td>
             <td><form:input path="yearOfAdmission" /></td>
         </tr>
         <tr></tr>
         <tr></tr>
        <tr>
            <td>Branch: </td>
            <td><form:input path="branch" /></td>
        </tr>
        <tr></tr>
        <tr></tr>
         <tr>
             <td>Usn: </td>
             <td><form:input path="usn" /> </td>
             <td><form:errors path="usn" cssClass="error"/> </td>
         </tr>
         <tr></tr>
         <tr></tr>
         <tr></tr>
        <tr>
          <td colspan="2"><input type="submit" value="<c:out value="${student.id != null ? 'Update' : 'Register'}"/>"
          >&nbsp;&nbsp; <a href="/studentManage/list">Student List</a>&nbsp;
          <c:if test="${student.id ne null}"><b>|</b>&nbsp;<a href="/studentManage/registration">Registration</a></c:if>
          </td>
          </tr>
        </table>
      </form:form>
    </body>
  </html>
