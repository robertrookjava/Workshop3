<%--
    Document   : category
    Created on : Jun 9, 2010, 3:59:32 PM
    Author     : tgiunipero
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<sql:query var="categories" dataSource="jdbc/affablebean">
    SELECT * FROM category
</sql:query>
<sql:query var="selectedCategory" dataSource="jdbc/affablebean">
    SELECT name FROM category WHERE id = ?
    <sql:param value="${pageContext.request.queryString}"/>
</sql:query>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/affablebean.css">
        <title>The Affable Bean</title>
    </head>
    <body>
        <div id="main">
            <div id="header">
                <div id="widgetBar">

                    <div class="headerWidget">
                        [ language toggle ]
                    </div>

                    <div class="headerWidget">
                        [ checkout button ]
                    </div>

                    <div class="headerWidget">
                        [ shopping cart widget ]
                    </div>

                </div>

                <a href="#">
                    <img src="#" id="logo" alt="Affable Bean logo">
                </a>

                <img src="#" id="logoText" alt="the affable bean">
            </div>

            <div id="categoryLeftColumn">
                <c:forEach var="category" items="${categories.rows}">

        <c:choose>
            <c:when test="${category.id == pageContext.request.queryString}">
                <div class="categoryButton" id="selectedCategory">
                    <span class="categoryText">
                        ${category.name}
                    </span>
                </div>
            </c:when>
            <c:otherwise>
                <a href="category?${category.id}" class="categoryButton">
                    <div class="categoryText">
                        ${category.name}
                    </div>
                </a>
            </c:otherwise>
        </c:choose>

    </c:forEach>

            </div>

            <div id="categoryRightColumn">
                <p id="categoryTitle">${selectedCategory.rows[0].name}</p>

                <table id="productTable">
                    <tr>
                        <td class="lightBlue">
                            <img src="#" alt="product image">
                        </td>
                        <td class="lightBlue">
                            [ product name ]
                            <br>
                            <span class="smallText">[ product description ]</span>
                        </td>
                        <td class="lightBlue">[ price ]</td>
                        <td class="lightBlue">
                            <form action="#" method="post">
                                <input type="submit" value="purchase button">
                            </form>
                        </td>
                    </tr>

                    <tr>
                        <td class="white">
                            <img src="#" alt="product image">
                        </td>
                        <td class="white">
                            [ product name ]
                            <br>
                            <span class="smallText">[ product description ]</span>
                        </td>
                        <td class="white">[ price ]</td>
                        <td class="white">
                            <form action="#" method="post">
                                <input type="submit" value="purchase button">
                            </form>
                        </td>
                    </tr>

                    <tr>
                        <td class="lightBlue">
                            <img src="#" alt="product image">
                        </td>
                        <td class="lightBlue">
                            [ product name ]
                            <br>
                            <span class="smallText">[ product description ]</span>
                        </td>
                        <td class="lightBlue">[ price ]</td>
                        <td class="lightBlue">
                            <form action="#" method="post">
                                <input type="submit" value="purchase button">
                            </form>
                        </td>
                    </tr>

                    <tr>
                        <td class="white">
                            <img src="#" alt="product image">
                        </td>
                        <td class="white">
                            [ product name ]
                            <br>
                            <span class="smallText">[ product description ]</span>
                        </td>
                        <td class="white">[ price ]</td>
                        <td class="white">
                            <form action="#" method="post">
                                <input type="submit" value="purchase button">
                            </form>
                        </td>
                    </tr>
                </table>
            </div>

            <div id="footer">
                <hr>
                <p id="footerText">[ footer text ]</p>
            </div>
        </div>
    </body>
</html>