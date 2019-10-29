
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Laboratorio 06 - Factory Method</title>
    </head>
    <body>

        <nav class="navbar navbar-dark bg-dark">
            <a class="navbar-brand" href="#">Sakila</a>
        </nav>

        <div class="container">
            <br>
            <div class="row">
                <h1>Lista de clientes por país</h1>
            </div>

            <br>

            <form method="POST" action="customerServlet">

                <div class="row">
                    <div class="form-group col-8">
                        <label for="exampleFormControlSelect1">Example select</label>
                        <select class="form-control" id="exampleFormControlSelect1">
                            <c:forEach items="${countries}" var="item">
                                <option value="${item.getCountry_id()}">${item.getCountry()}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="col-4 mt-4">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </div>



            </form>

            <br>

            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido</th>
                        <th scope="col">Ciudad</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${customers}" var="item">
                        <tr>
                            <th scope="row">${item.getCustomer_id()}</th>
                            <td>${item.getFirst_name()}</td>
                            <td>${item.getLast_name()}</td>
                            <td>${item.getAddress().getCity().getCity()}</td>
                        </tr>
                    </c:forEach>


                </tbody>
            </table>

        </div>

    </body>
</html>
