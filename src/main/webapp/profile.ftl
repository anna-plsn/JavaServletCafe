<#ftl encoding="UTF-8"/>

<#import "base.ftl" as base>

<@base.main css = ["style"]>
    <style>
        body {
            background-color: #f8f9fa;
            border-radius: 10px
        }

        .card {
            width: 400px;
            border: none;
            border-radius: 10px;
            background-color: #fff
        }

    </style>

    <div class="container mt-5 d-flex justify-content-center">
        <div class="card p-3">
            <div class="d-flex align-items-center">
                <div class="image">

<#--image upload-->
                    <div class="profile-img">
                        <img alt="User Pic" src="/img?filename=${user.getImage()}" id="profile-image1"
                             class="rounded" width="370">
                    </div>
                    <br>
                    <h2>${user.getSurname()}</h2> <span>${user.getName()}</span>
                    <br><br>

<#--                    upload file-->
                    <form action="/upload" method="post" enctype="multipart/form-data">
                        <div class="form-group" enctype="multipart/form-data">
                            <div class="input-group mb-3">

                                <div class="custom-file" enctype="multipart/form-data">
                                    <input name="file" type="file" class="custom-file-input" id="customFile">
                                    <label class="custom-file-label" for="customFile">Choose file for avatar</label>
                                </div>
                                <div class="input-group-append">
                                    <button class="btn btn-outline-secondary" name="submit" type="submit"
                                            value="Push Track">
                                        Upload
                                    </button>
                                </div>

                            </div>
                        </div>
                    </form>

<#--                    emal-->
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <div class="input-group-text" id="basic-addon1">@</div>
                        </div>
                        <div class="form-control" aria-describedby="basic-addon1">${user.getEmail()}</div>
                    </div>
                    <br>
<#--                    exit-->
                    <form action="/exit" method="get">
                    <p class="float-right"><a type="button" class="btn btn-secondary btn-lg" href="/exit">Exit</a></p>
                    </form>
                </div>


            </div>
        </div>
    </div>
</@base.main>