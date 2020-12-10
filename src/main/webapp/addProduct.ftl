<#ftl encoding="UTF-8"/>
<#import "admin.ftl" as admin>

<@admin.main css = ["style"]>


    <form action="/addProduct" method="post" enctype="multipart/form-data">
        <div class="container">
            <div class="form-group">
                <br>
                <label for="exampleInputPassword1">Name</label>
                <br>
                <input type="text" class="form-control" name="name" placeholder="potato">
            </div>

                <div class="form-group" enctype="multipart/form-data">
                    <label for="exampleFormControlFile1">Choose a file for image catalog</label>
                    <br>
                    <input name="file" type="file" accept="image/*,image/jpeg">
                </div>
            <br>
            <button type="submit" class="btn btn-primary">Submit</button>
            <br>
            <br>
            <p>${error}</p>
        </div>

    </form>

</@admin.main>