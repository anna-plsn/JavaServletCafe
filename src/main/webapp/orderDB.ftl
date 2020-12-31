<#ftl encoding="UTF-8"/>

<#import "admin.ftl" as admin>
<@admin.main css = ["style"]>

    <br>
    <div class="container">
        <form method="post" action="/tableOrderDB">
            <div class="input-group">

                <#--            select option-->
                <select class="custom-select" id="inputGroupSelect04" name="id">
                    <option selected>Choose user...</option>
                    <#list users as user>
                        <option class="option" value="${user.getId()}">${user.getName()} ${user.getSurname()} |
                            email: ${user.getEmail()}</option>
                    </#list>
                </select>

                <#--            get orders button-->
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary" type="submit">Get orders</button>
                </div>
            </div>
        </form>
        <br>
        <div class="row">
            <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                <!-- Shopping cart table -->
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>

                            <#--                            Product-->
                            <th scope="col" class="border-0 bg-light">
                                <div class="p-2 px-3 text-uppercase">Product</div>
                            </th>

                            <#--                            price-->
                            <th scope="col" class="border-0 bg-light">
                                <div class="py-2 text-uppercase">Price</div>
                            </th>

                            <#--                            quantity-->
                            <th scope="col" class="border-0 bg-light">
                                <div class="py-2 text-uppercase">Quantity</div>
                            </th>
                        </tr>
                        </thead>
                        <#list carts as cart>
                            <tbody>
                            <tr>

                                <#--product name-->
                                <th scope="row" class="border-0">
                                    <div class="p-2">
                                        <div class="ml-3 d-inline-block align-middle">
                                            <h5 class="mb-0"> ${cart.getName()}</h5>
                                        </div>
                                    </div>
                                </th>

                                <#--                                product price-->
                                <td class="border-0 align-middle"><strong>${cart.getPrice()} <span
                                                class="text-small font-weight-normal ml-2">rub / am.</span></strong>
                                </td>

                                <#--                                product quantity-->
                                <td class="border-0 align-middle"><strong>${cart.getQuantity()}</strong></td>
                            </tr>

                            </tbody>
                        </#list>
                    </table>
                </div>
                <br>
                <!-- End -->
            </div>
        </div>
    </div>

</@admin.main>