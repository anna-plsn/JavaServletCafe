<#ftl encoding="UTF-8"/>

<#import "base.ftl" as base>

<@base.main css = ["style"]>
    <br>
    <h1 class="text-center"> Your cart </h1>
    <div class="pb-5">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                    <!-- Shopping cart table -->
                    <div class="table-responsive">
                        <table class="table">
                            <thead>
                            <tr>
                                <#--                                Product-->
                                <th scope="col" class="border-0 bg-light">
                                    <div class="p-2 px-3 text-uppercase">Product</div>
                                </th>

                                <#--                                Price-->
                                <th scope="col" class="border-0 bg-light">
                                    <div class="py-2 text-uppercase">Price</div>
                                </th>

                                <#--                                Quantity-->
                                <th scope="col" class="border-0 bg-light">
                                    <div class="py-2 text-uppercase">Quantity</div>
                                </th>

                                <#--                                Remove-->
                                <th scope="col" class="border-0 bg-light">
                                    <div class="py-2 text-uppercase">Remove</div>
                                </th>
                            </tr>
                            </thead>
                            <#list carts as cart>

                                <tbody>
                                <tr>
                                    <#--                                    Name product-->
                                    <th scope="row" class="border-0">
                                        <div class="p-2">
                                            <div class="ml-3 d-inline-block align-middle">
                                                <h5 class="mb-0"> ${cart.getName()}</h5>
                                            </div>
                                        </div>
                                    </th>

                                    <#--                                    Price product-->
                                    <td class="border-0 align-middle"><strong>${cart.getPrice()} <span
                                                    class="text-small font-weight-normal ml-2">rub / am.</span></strong>
                                    </td>

                                    <#--                                    Quantity product-->
                                    <td class="border-0 align-middle"><strong>${cart.getQuantity()}</strong></td>

                                    <#--                                    Delete product from cart-->
                                    <td class="border-0 align-middle"><a
                                                href="/deleteCart?id_product=${cart.getId_product()}&id_user=${user.getId()}"
                                                class="text-dark"><i
                                                    class="fa fa-trash"></i></a></td>
                                </tr>

                                </tbody>
                            </#list>
                        </table>
                    </div>
                    <br>
                    <#--                    info about empty cart-->
                    <h3 class="text-center">${empty_cart}</h3>
                    <br>
                    <#--                    button for pay product in cart-->
                    <a href="/checkout"
                       class="btn btn-dark rounded-pill py-2 btn-block">Proceed to checkout</a>

                </div>
            </div>
        </div>
    </div>
</@base.main>