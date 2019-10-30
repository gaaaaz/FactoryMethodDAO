
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
            <a class="navbar-brand" href="">Sakila Database</a>
        </nav>

        <div class="container">
            <br>
            <div class="row">
                <h1>Lista de clientes por país</h1>
            </div>

            <br>

            <form method="POST" action="customer_per_country">

                <div class="row">
                    <div class="form-group col-8">
                        
                        <select class="form-control" id="exampleFormControlSelect1" name="country_id">
                            <c:forEach items="${countries}" var="item">
                                <option value="${item.getCountry_id()}">${item.getCountry()}</option>
                            </c:forEach>
                        </select>
                        <small>Seleccionar país</small>
                    </div>

                    <div class="col-4 mb-3">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </div>



            </form>

            <br>
            
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col" class="text-center">Nombre</th>
                        <th scope="col" class="text-center">Apellido</th>
                        <th scope="col" class="text-center">Teléfono</th>
                        <th scope="col" class="text-center">Distrito</th>
                        <th scope="col" class="text-center">Dirección</th>
                        <th scope="col" class="text-center">Código postal</th>
                        <th scope="col" class="text-center">Ciudad</th>
                    </tr>
                </thead>
                <tbody>
                    
                    
                    <c:forEach items="${customers}" var="item">
                        <tr>
                            <td class="text-center">${item.getFirst_name()}</td>
                            <td class="text-center">${item.getLast_name()}</td>
                            <td class="text-center">${item.getAddress().getPhone()}</td>
                            <td class="text-center">${item.getAddress().getDistrict()}</td>
                            <td class="text-center">${item.getAddress().getAddress()}</td>
                            <td class="text-center">${item.getAddress().getPostal_code()}</td>
                            <td class="text-center">${item.getAddress().getCity().getCity()}</td>
                        </tr>
                    </c:forEach>


                </tbody>
            </table>

        </div>

    </body>
</html>
