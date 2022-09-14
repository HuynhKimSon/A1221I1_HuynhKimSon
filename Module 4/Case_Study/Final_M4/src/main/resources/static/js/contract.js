$(document).ready(function () {

    // Load data
    $.ajax({
        type: "POST",
        url: "/contract/list",
        dataType: "json",
        success: function (data) {
            console.log(data);
            showList(data)
        }
    });

    // Open modal create
    $("#btn-create").click(function () {
        $("#form-create").trigger("reset");
        $("#contractId").val("0");
        $('#createModal').modal('show');
        $.ajax({
            type: "GET",
            url: "/contract/houseType",
            dataType: "json",
            success: function (data) {
                $.each(data, function (index, option) {
                    $("select[name=house]").find('[value="' + option.idHouse + '"]').remove();
                    let idHouse = "PT-" + option.idHouse;
                    $("select[name=house]").append('<option value="' + option.idHouse + '">' + idHouse + '</option>')
                });
            }
        })
    });

    // Create
    $("#btn-submit-create").click(function () {
        let dataRequest = {
            idContract: $("#idContract").val(),
            house: $("#house").val(),
            nameCustomer: $("#nameCustomer").val(),
            idCard: $("#idCard").val(),
            createTime: $("#createTime").val(),
            typeTime: $("#typeTime").val(),
        }
        $.ajax({
            type: "POST",
            url: "/contract/create",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data: JSON.stringify(dataRequest),
            success: function (data) {

                if (data.code == 200) {
                    showList(data.contracts);
                    $("#form-create").trigger("reset");
                    $('#createModal').modal('hide');
                    $('#notification-success').modal('show');
                    setTimeout(function () {
                        $('#notification-success').modal('hide');
                    }, 1200);
                }
            }
        })
    });
});