$(document).ready(function () {
    // Load data
    $.ajax({
        method: "POST",
        url: "/blog",
        dataType: "json",
        success: function (data) {
            var  html = `<thead>
                            <tr>
                                <th scope="col">No.</th>
                                <th scope="col" style="width: 500px">Title</th>
                                <th scope="col">Author</th>
                                <th scope="col" style="width: 200px">Create time</th>
                                <th scope="col">Image</th>
                                <th scope="col" style="width: 200px">Action</th>
                            </tr>
                         </thead>
                         <tbody>`;
            for (let i = 0; i < data.length; i++) {
                html += `<tr>
                            <td>`+(i+1)+`</td>
                            <td>`+data[i].title+`</td>
                            <td>`+data[i].author+`</td>
                            <td>`+data[i].createTime+`</td>
                            <td><img src="/image/`+data[i].image+`" height="150px"
                            width="250px"/></td>
                            <td>
                                <a style="color: blue" id="btn-detail" data-id="`+data[i].id+`">
                                    <i class="bi bi-eye-fill"></i>
                                </a>
                                <a id="btn-edit">
                                    <i class="bi bi-pencil-square"></i>
                                </a>
                                <a style="color: red" id="btn-delete" 
                                    <i class="bi bi-trash3-fill"></i>
                                </a>
                            </td>
                        </tr>`
            }
            html+="</tbody>"
            document.getElementById('blogTable').insertAdjacentHTML('beforeend', html);
        }
    })

    // Show detail
    $("#btn-detail").click(function () {
        let dataRequest = {
            id: $(this).data('id')
        }
        console.log(dataRequest);
        $.ajax({
            method: "POST",
            url: "/blog/detail",
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(dataRequest),
            success: function () {
                
            }
        })
    })

});