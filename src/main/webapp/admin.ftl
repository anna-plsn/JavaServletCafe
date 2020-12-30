<#macro main css = [] js = []>
    <html>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!------ Include the above in your HEAD tag ---------->


    <head>
        <title>navbar</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">


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
                        <a class="nav-link" href="/addProduct">Add product<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/db">User database</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/productDB">Product database</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/orderDB">Order database</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/exitAdmin">Exit</a>
                    </li>

                </ul>

            </div>
        </nav>
    </header>
    <#nested >

    </body>
    </html>



</#macro>