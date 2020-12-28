<#ftl encoding="UTF-8"/>

<#import "admin.ftl" as admin>
<@admin.main css = ["style"]>
    <body>
    <br>
    <div class="container">
        <table class="table table-bordered table-striped">
            <tr>
                <th>Name</th>
                <th>Image</th>
                <th>Price</th>
                <th>Delete</th>
            </tr>
            <#list products as product>

                <tr>
                    <td>${product.getName()}</td>
                    <td>${product.getImage()}</td>
                    <td>${product.getPrice()}</td>
                    <td><a href="/qwer/deleteProduct?id=${product.getId()}">Delete</a></td>
                </tr>
            </#list>
        </table>

    </div>
    </body>

</@admin.main>