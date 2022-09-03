$(document).ready(function () {
    // Load data
    $.ajax({
        method: "POST",
        url: "/customer/list",
        dataType: "json",
        success: function (data) {
            console.log(data);
            var html = "";
            for (let i = 0; i < data.length; i++) {
                html += `<tr>
                            <td>` + (i + 1) + `</td>
                            <td>` + data[i].name + `</td>
                            <td>` + data[i].customerGender + `</td>
                            <td>` + data[i].customerPhone + `</td>
                            <td>` + data[i].customerType.customerTypeName + `</td>
                            <td>` + data[i].customerEmail + `</td>
                            <td>
                                 <a style="color: blue" id="btn-detail" onclick="viewDetail(` + data[i].id + `)">
                                    <i class="bi bi-eye-fill"></i>
                                </a>
                                <a style="color: blue" id="btn-edit" onclick="update(` + data[i].id + `)">
                                    <i class="bi bi-pencil-square"></i>
                                </a>
                                <a type="button" style="color: red" id="btn-delete" onclick="remove(` + data[i].id + `)">
                                    <i class="bi bi-trash3-fill"></i>
                                </a>
                            </td>
                        </tr>`
            }
            document.getElementById('table-customer').insertAdjacentHTML('beforeend', html);
        }
    });

    // Create
    $("#btn-submit-create").click(function () {
        let formData = new FormData;
        let image = $("#image")[0];
        formData.append("id", $("#id").val());
        formData.append("title", $("#title").val());
        formData.append("author", $("#author").val());
        formData.append("content", $("#content").val());
        formData.append("image", image.files[0]);
        $("#form-create").trigger("reset");
        $.ajax({
            method: "POST",
            url: "/blog/create",
            dataType: "json",
            contentType: false,
            processData: false,
            data: formData,
            success: function (data) {
                var html = `<table class="table table-hover table-striped text-center align-content-center" id="blogTable">
                                <thead>
                                    <tr>
                                        <th scope="col">No.</th>
                                        <th scope="col" style="width: 500px">Title</th>
                                        <th scope="col">Author</th>
                                        <th scope="col" style="width: 200px">Create time</th>
                                        <th scope="col">Image</th>
                                        <th scope="col" style="width: 200px">Action</th>
                                     </tr>
                                </thead>`;
                for (let i = 0; i < data.length; i++) {
                    html += `<tr>
                            <td>` + (i + 1) + `</td>
                            <td>` + data[i].title + `</td>
                            <td>` + data[i].author + `</td>
                            <td>` + data[i].createTime + `</td>
                            <td><img src="/image/` + data[i].image + `" height="150px"
                            width="250px"/></td>
                            <td>
                                <a style="color: blue" id="btn-detail" onclick="detail(` + data[i].id + `)">
                                    <i class="bi bi-eye-fill"></i>
                                </a>
                                <a id="btn-edit" onclick="edit(` + data[i].id + `)">
                                    <i class="bi bi-pencil-square"></i>
                                </a>
                                 <a type="button" style="color: red" id="btn-delete" onclick="remove(` + data[i].id + `)">
                                    <i class="bi bi-trash3-fill"></i>
                                </a>
                            </td>
                        </tr>`
                }
                html += '</table>';
                document.getElementById("blogTable").innerHTML = html;
                $('#createModal').modal('hide');
                $('#notification-success').modal('show');
                setTimeout(function () {
                    $('#notification-success').modal('hide');
                }, 1500);
            }
        })
    });
});