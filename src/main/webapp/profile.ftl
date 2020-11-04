<#ftl encoding="UTF-8"/>

<#import "base.ftl" as base>

<@base.main css = ["style"]>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    <div class="container">
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading"><h4>User Profile</h4></div>
                <div class="panel-body">
                    <div class="col-md-4 col-xs-12 col-sm-6 col-lg-4">
                        <img alt="User Pic"
                             src="/img?filename=${user.getImage()}"
                             id="profile-image1" class="img-circle img-responsive">


                    </div>
                    <div class="col-md-8 col-xs-12 col-sm-6 col-lg-8">
                        <div class="container">
                            <h2>${user.getSurname()}</h2>
                            <p>${user.getName()}</p>


                        </div>
                        <hr>
                        <ul class="container details">
                            <li><p><span class="glyphicon glyphicon-user one" style="width:50px;"></span>i.rudberg</p>
                            </li>
                            <li><p><span class="glyphicon glyphicon-envelope one"
                                         style="width:50px;"></span>${user.getEmail()}</p></li>
                        </ul>
                        <hr>
                        <form action="/upload" method="post" enctype="multipart/form-data">
                            <div class="form-group"
                                 enctype="multipart/form-data">
                                <label for="exampleFormControlFile1">Choose a file for avatar</label>
                                <input name = "file" type="file" accept="image/*,image/jpeg">

                                <br>
                                <button class="btn btn-primary" name="submit" type="submit" value="Push Track">Upload</button>
                            </div>
                        </form>

                        <br>
                        <form action="/exit" method="get">
                        <a type="button" class="btn btn-secondary btn-lg" href="/exit">Exit</a>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </div>
</@base.main>