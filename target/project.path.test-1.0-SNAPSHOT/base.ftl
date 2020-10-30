<#macro main css = [] js = []>
<html>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->


<head>
    <title>navbar</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=Raleway:400,500,500i,700,800i" rel="stylesheet">
    <#list css as style>
        <link rel="stylesheet" href="/css/${style}.css">
    </#list>
</head>
<body>
<header>

    <nav class="navbar navbar-expand-sm   navbar-light bg-light">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="/">Hello<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/db">Database</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/register">Add element</a>
                </li>
            </ul>
            <form class="form-inline" action="/search" method="get">
                <input class="form-control mr-sm-2" type="text" name="name" placeholder="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
            <!-- <li class="nav-item dropdown dmenu">
             <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
               Dropdown link
             </a>
             <div class="dropdown-menu sm-menu">
               <a class="dropdown-item" href="#">Link 1</a>
               <a class="dropdown-item" href="#">Link 2</a>
               <a class="dropdown-item" href="#">Link 3</a>
               <a class="dropdown-item" href="#">Link 4</a>
               <a class="dropdown-item" href="#">Link 5</a>
               <a class="dropdown-item" href="#">Link 6</a>
             </div>
           </li> -->
        </div>
    </nav>
</header>
<#nested >

</body>
</html>



</#macro>