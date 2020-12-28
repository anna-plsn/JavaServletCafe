<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<!------ Include the above in your HEAD tag ---------->

<html>
<head>
    <title>Ann's cafe</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=Raleway:400,500,500i,700,800i" rel="stylesheet">
    <style>
        p {
            color: black;
        }

        h1 {
            font-family: "Avant Garde", Avantgarde, "Century Gothic", CenturyGothic, "AppleGothic", sans-serif;
            font-size: 92px;
            padding: 80px 50px;
            text-align: center;
            text-transform: uppercase;
            text-rendering: optimizeLegibility;
        }

        .elegant {
            color: #131313;
            background-color: #e7e5e4;
            letter-spacing: .15em;
            text-shadow: 1px -1px 0 #767676, -1px 2px 1px #737272, -2px 4px 1px #767474, -3px 6px 1px #787777, -4px 8px 1px #7b7a7a, -5px 10px 1px #7f7d7d, -6px 12px 1px #828181, -7px 14px 1px #868585, -8px 16px 1px #8b8a89, -9px 18px 1px #8f8e8d, -10px 20px 1px #949392, -11px 22px 1px #999897, -12px 24px 1px #9e9c9c, -13px 26px 1px #a3a1a1, -14px 28px 1px #a8a6a6, -15px 30px 1px #adabab, -16px 32px 1px #b2b1b0, -17px 34px 1px #b7b6b5, -18px 36px 1px #bcbbba, -19px 38px 1px #c1bfbf, -20px 40px 1px #c6c4c4, -21px 42px 1px #cbc9c8, -22px 44px 1px #cfcdcd, -23px 46px 1px #d4d2d1, -24px 48px 1px #d8d6d5, -25px 50px 1px #dbdad9, -26px 52px 1px #dfdddc, -27px 54px 1px #e2e0df, -28px 56px 1px #e4e3e2;
        }

        .container {
            padding: 5%;
        }

        .container .img {
            text-align: center;
        }

        .container .details {
            border-left: 3px solid #ded4da;
        }

        .container .details p {
            font-size: 15px;
            font-weight: bold;
        }

        .qty .count {
            color: #000;
            display: inline-block;
            vertical-align: top;
            font-size: 25px;
            font-weight: 700;
            line-height: 30px;
            padding: 0 2px;
            min-width: 35px;
            text-align: center;
        }

        .qty .plus {
            cursor: pointer;
            display: inline-block;
            vertical-align: top;
            color: white;
            width: 30px;
            height: 30px;
            font: 30px/1 Arial, sans-serif;
            text-align: center;
            border-radius: 50%;
        }

        .qty .minus {
            cursor: pointer;
            display: inline-block;
            vertical-align: top;
            color: white;
            width: 30px;
            height: 30px;
            font: 30px/1 Arial, sans-serif;
            text-align: center;
            border-radius: 50%;
            background-clip: padding-box;
        }

        div {
            text-align: center;
        }

        .minus:hover {
            background-color: #717fe0 !important;
        }

        .plus:hover {
            background-color: #717fe0 !important;
        }

        /*Prevent text selection*/
        span {
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
        }

        input {
            border: 0;
            width: 2%;
        }

        nput::-webkit-outer-spin-button,
        input::-webkit-inner-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }

        input:disabled {
            background-color: white;
        }
    </style>
</head>
<body>
<header>
    <%--navbar--%>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03"
                aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item active">
                    <a class="nav-link" href="/">Catalog<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/login">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/profile">Profile</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0" method="post" action="/cart">
                <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Cart
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                         class="bi bi-cart" viewBox="0 0 16 16">
                        <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                    </svg>
                </button>
            </form>
        </div>
    </nav>

</header>
<%--jsp-code for loop --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--label--%>
<h1 class="elegant">Welcome to our cafe!</h1>
<% if (request.getAttribute("user_login")=="1"){%>
<div class="alert alert-warning">
    You can't buy any products, because you are not logged in. Please, login or register
</div>
<% };%>
<%
    int i = 0;
%>
<%--items for catalog--%>
<div class="album py-5 bg-light">
    <div class="container">
        <c:forEach var="product" items="${products}">
            <%i = i + 1;%>
            <% if (i % 3 == 1) {%>
            <%--first column--%>
            <div class="row">
                <div class="col-md-4">
                    <div class="card mb-4 box-shadow">
                        <img class="card-img-top" src="/img?filename=${product.image}" alt="Card image cap">
                        <div class="card-body">
                            <p class="card-text">I am <c:out value="${product.name}"></c:out></p>
                            <h5>${product.price} rub<span class="text-small font-weight-normal ml-2">/ am.</span></h5>
                            <input type="hidden" name="product_id" value="0">
                            <div class="qty mt-5">
                                <span class="minus bg-dark">-</span>
                                <input type="number" class="count" name="count" value="0">
                                <span class="plus bg-dark">+</span>
                            </div>
                            <br>
                                <%--buy and cart buttons--%>
                            <a href="/addToCart?id=${product.id}&name=${product.name}" class="text-dark" id="buy_link">
                                <button class="btn btn-dark btn-block" id="buy_button">Buy now
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                         class="bi bi-credit-card-2-back" viewBox="0 0 16 16">
                                        <path d="M11 5.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1-.5-.5v-1z"/>
                                        <path d="M2 2a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V4a2 2 0 0 0-2-2H2zm13 2v5H1V4a1 1 0 0 1 1-1h12a1 1 0 0 1 1 1zm-1 9H2a1 1 0 0 1-1-1v-1h14v1a1 1 0 0 1-1 1z"/>
                                    </svg>
                                </button>
                            </a>
                            <br>
                            <a href="/addToCart?id=${product.id}&name=${product.name}" class="text-success" id="cart_link">
                                <button class="btn btn-success btn-block" type="submit" name="id" value="${product.id}">
                                    Add to cart
                                    <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18"
                                         fill="currentColor" class="bi bi-cart" viewBox="0 0 18 18">
                                        <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                                    </svg>
                                </button>
                            </a>

                        </div>
                    </div>
                </div>
                <% }
                    ;%>
                    <%--second column--%>
                <% if (i % 3 == 2) {%>
                <div class="col-md-4">
                    <div class="card mb-4 box-shadow">
                        <img class="card-img-top" src="/img?filename=${product.image}" alt="Card image cap">
                        <div class="card-body">
                            <p class="card-text">I am <c:out value="${product.name}"></c:out></p>
                            <h5>${product.price} rub<span class="text-small font-weight-normal ml-2">/ am.</span></h5>
                            <form method="post" action="">
                                <input type="hidden" name="product_id" value="0">
                                <div class="qty mt-5">
                                    <span class="minus bg-dark">-</span>
                                    <input type="number" class="count" name="count" value="0">
                                    <span class="plus bg-dark">+</span>
                                </div>
                            </form>
                            <form action="/addToCart" method="get">
                                <button type="submit" class="btn btn-dark btn-block" name="id" value="${product.id}">Add
                                    to cart
                                </button>
                            </form>

                        </div>
                    </div>
                </div>
                <% }
                    ;%>
                    <%--third column--%>
                <% if (i % 3 == 0) {%>
                <div class="col-md-4">
                    <div class="card mb-4 box-shadow">
                        <img class="card-img-top" src="/img?filename=${product.image}" alt="Card image cap">
                        <div class="card-body">
                            <p class="card-text">I am <c:out value="${product.name}"></c:out></p>
                            <h5>${product.price} rub<span class="text-small font-weight-normal ml-2">/ am.</span></h5>
                            <form method="post" action="">
                                <input type="hidden" name="product_id" value="0">
                                <div class="qty mt-5">
                                    <span class="minus bg-dark">-</span>
                                    <input type="number" class="count" name="count" value="0">
                                    <span class="plus bg-dark">+</span>
                                </div>
                            </form>
                            <form action="/addToCart" method="get">
                                <button type="submit" class="btn btn-dark btn-block" name="id" value="${product.id}">Add
                                    to cart
                                </button>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
            <% }
                ;%>
        </c:forEach>
    </div>
</div>
<%--script for plus and minus--%>
<script>
    $(document).ready(function () {
        $('.count').prop('disabled', true);
        $(document).on('click', '.plus', function () {
            $(this).prev().val(+$(this).prev().val() + 1);

        });
        $(document).on('click', '.minus', function () {
            if ($(this).next().val() > 0) $(this).next().val(+$(this).next().val() - 1);
        });
    });
    $(function() {
        $('#buy_link').each(function (){
            $('#buy_link').click(function () {
                $('#buy_link').attr("href", $('#buy_link').attr("href") + "&quantity=" + $('.plus').prev().val());
            });
        });

});
</script>
<%--footer information adn link to top--%>
<footer class="text-muted">

    <div class="container">
        <p class="float-right">
            <a href="#" class="text-muted">Back to top</a>
        </p>
        <p class="float-left">It is cafe &copy; anna.studio</p>
    </div>
</footer>
</body>
</html>
