$(document).ready(function () {

    // Load data
    $.ajax({
        type: "POST",
        url: "/customer/list",
        dataType: "json",
        success: function (data) {
            showList(data)
        }
    });

    // Open modal create
    $("#btn-create").click(function () {
        $("#form-create").trigger("reset");
        $("#customerId").val("0");
        $('#createModal').modal('show');
        validate(null);
        $.ajax({
            type: "GET",
            url: "/customer/customerType",
            dataType: "json",
            success: function (data) {
                $.each(data, function (index, option) {
                    $("select[name=customerTypeId]").find('[value="' + option.customerTypeId + '"]').remove();
                    $("select[name=customerTypeId]").append('<option value="' + option.customerTypeId + '">' + option.customerTypeName + '</option>')
                });
            }
        })
    })

    // Create
    $("#btn-submit-create").click(function () {
        let dataRequest = {
            customerId: $("#customerId").val(),
            customerName: $("#customerName").val(),
            customerTypeId: $("#customerTypeId").val(),
            customerBirthday: $("#customerBirthday").val(),
            customerGender: $('input[name="customerGender"]:checked').val(),
            customerIdCard: $("#customerIdCard").val(),
            customerPhone: $("#customerPhone").val(),
            customerEmail: $("#customerEmail").val(),
            customerAddress: $("#customerAddress").val(),
        }
        $.ajax({
            type: "POST",
            url: "/customer/create",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data: JSON.stringify(dataRequest),
            success: function (data) {
                validate(data.errors)

                if (data.code == 200) {
                    showList(data.customers);
                    $("#form-create").trigger("reset");
                    $('#createModal').modal('hide');
                    $('#notification-success').modal('show');
                    setTimeout(function () {
                        $('#notification-success').modal('hide');
                    }, 1500);
                }
            }
        })
    });
});