$(document).ready(function () {
    var IDs = "";
    // Delete Modal
    $('.btn_delete').click(function () {
        let id = $(this).data('id');
        if (id != null) {
            IDs = id;
        } else {
            IDs = $(".file_id:checked").map(function () {
                return this.value;
            }).toArray();
        }
        console.log("IDs : " + IDs);
        $('.btn_confirm_delete').attr('href', '/customer?action=delete&id=' + IDs + '');
    });

    // Fill input edit Modal
    $('.btn_edit').click(function () {
        let customerId = $(this).data('id');
        let customerName = $(this).closest("tr").find('td.customer_name').text();
        let customerBirthday = $(this).closest("tr").find('td.customer_birthday').text();
        let customerGender = $(this).closest("tr").find('td.customer_gender').text();
        let customerIdCard = $(this).closest("tr").find('td.customer_id_card').text();
        let customerPhone = $(this).closest("tr").find('td.customer_phone').text();
        let customerEmail = $(this).closest("tr").find('td.customer_email').text();
        let customerType = $(this).closest("tr").find('td.customer_type_name').text();
        let customerAddress = $(this).closest("tr").find('td.customer_address').text();

        $('.customer_id').val(customerId);
        $('.customer_name').val(customerName);
        $('.customer_birthday').val(customerBirthday);
        $('#dropdown_customer_gender option:contains("' + customerGender + '")').attr('selected', 'selected');
        $('.customer_id_card').val(customerIdCard);
        $('.customer_phone').val(customerPhone);
        $('.customer_email').val(customerEmail);
        $('#dropdown_customer_type option:contains("' + customerType + '")').attr('selected', 'selected');
        $('.customer_address').val(customerAddress);

    });

    // Check all, uncheck all
    $("#checkAll").change(function (event) {
        let checkbox = $(event.target).closest('table');
        $('td input:checkbox', checkbox).prop('checked', this.checked);
        event.preventDefault();
    });

    // Submit search
    $('.btn_submit_search').click(function () {
        let key = $('#select_sort option:selected').val();
        let value = $('#input_search').val();
        $('#form_search').attr('action', '/customer?action=search&key=' + key + '' + '&value=' + value + '');
    })
});