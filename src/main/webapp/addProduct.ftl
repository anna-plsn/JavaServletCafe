<#ftl encoding="UTF-8"/>
<#import "admin.ftl" as admin>

<@admin.main css = ["style"]>


    <form action="/addProduct" method="post" enctype="multipart/form-data">
        <div class="container">

            <#--            input name for product-->
            <div class="form-group">
                <br>
                <label for="exampleInputPassword1">Name</label>
                <br>
                <input type="text" class="form-control" name="name" placeholder="potato">
            </div>
            <#--end-->

            <#--            input price for product-->
            <div class="form-group">
                <br>
                <label for="exampleInputPassword1">Price</label>
                <br>
                <input type="text" class="form-control" name="price" placeholder="34">
            </div>
            <#--end-->

            <#--            input image for product-->
            <div class="form-group" enctype="multipart/form-data">
                <label for="exampleFormControlFile1">Choose a file for image catalog</label>
                <br>
                <input name="file" type="file" accept="image/*,image/jpeg">
            </div>
            <#--            end-->
            <br>

            <#--            buttton for add product-->
            <button type="submit" class="btn btn-primary">Submit</button>
            <br>
            <br>
            <#--            info for admin about exist product-->
            <p>${error}</p>
        </div>

    </form>

</@admin.main>