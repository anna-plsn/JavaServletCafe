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

        #items {

            float: right;
        }

        #profile {
            margin-top: 19px;
            float: left;
        }

    </style>
    <div class="album py-5 bg-light">
        <div class="container">

                <div class="card p-3" id="profile">
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
                                            <label class="custom-file-label" for="customFile">Choose file for
                                                avatar</label>
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
                                <p class="float-right"><a type="button" class="btn btn-secondary btn-lg" href="/exit">Exit</a>
                                </p>
                            </form>
                        </div>


                    </div>
                </div>

                <br>

                <div class="pb-5" id="items">

                    <div class="row">
                        <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                            <h2 class="text-center">Your purchased items </h2>
                            <br>
                            <!-- Shopping cart table -->
                            <div class="table-responsive">
                                <table class="table">

                                    <thead>
                                    <tr>
                                        <th scope="col" class="border-0 bg-light">
                                            <div class="p-2 px-3 text-uppercase">Product</div>
                                        </th>
                                        <th scope="col" class="border-0 bg-light">
                                            <div class="py-2 text-uppercase">Price</div>
                                        </th>
                                        <th scope="col" class="border-0 bg-light">
                                            <div class="py-2 text-uppercase">Quantity</div>
                                        </th>
                                    </tr>
                                    </thead>
                                    <#list carts as cart>
                                        <tbody>
                                        <tr>

                                            <th scope="row" class="border-0">
                                                <div class="p-2">
                                                    <div class="ml-3 d-inline-block align-middle">
                                                        <h5 class="mb-0"> ${cart.getName()}</h5>
                                                    </div>
                                                </div>
                                            </th>
                                            <td class="border-0 align-middle"><strong>${cart.getPrice()} <span
                                                            class="text-small font-weight-normal ml-2">rub / am.</span></strong>
                                            </td>
                                            <td class="border-0 align-middle"><strong>${cart.getQuantity()}</strong>
                                            </td>
                                        </tr>

                                        </tbody>
                                    </#list>
                                </table>
                                <br>
                                <h3 class="text-center">${empty_paid}</h3>
                                <br>
                            </div>
                            <!-- End -->
                        </div>
                    </div>
                </div>

        </div>
    </div>
</@base.main>