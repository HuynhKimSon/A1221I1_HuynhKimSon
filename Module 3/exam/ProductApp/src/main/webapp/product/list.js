$(document).ready(function () {
    var IDs = "";
    // Delete Modal
    $('.btn-delete').click(function () {
        let id = $(this).data('id');
        if (id != null) {
            IDs = id;
        } else {
            IDs = $(".file_id:checked").map(function () {
                return this.value;
            }).toArray();
        }
        console.log("IDs : " + IDs);
        $('.btn-confirm-delete').attr('href', '/product?action=delete&id=' + IDs + '');
    });

    // Fill input edit Modal
    $('.btn-edit').click(function () {
        let id = $(this).data('id');
        let name = $(this).closest("tr").find('td.name').text();
        let price = $(this).closest("tr").find('td.price').text();
        let quantity = $(this).closest("tr").find('td.quantity').text();
        let color = $(this).closest("tr").find('td.color').text();
        let description = $(this).closest("tr").find('td.description').text();
        let category = $(this).closest("tr").find('td.category').text();

        console.log("id-edit : " + id);
        $('.id').val(id);
        $('.name').val(name);
        $('.price').val(price);
        $('.quantity').val(quantity);
        $('.color').val(color);
        $('.description').val(description);
        $('#dropdown-category option:contains("' + category + '")').prop('selected', true);
        console.log("selected-category : " + category);

    });

    // Check all, uncheck all
    $("#checkAll").change(function (event) {
        let checkbox = $(event.target).closest('table');
        $('td input:checkbox', checkbox).prop('checked', this.checked);
        event.preventDefault();
    });

    // Submit search
    $('.btn-submit-search').click(function () {
        let key = $('#select-sort option:selected').val();
        let value = $('#input-search').val();
        $('#form-search').attr('action', '/product?action=search&key=' + key + '' + '&value=' + value + '');
    })
});