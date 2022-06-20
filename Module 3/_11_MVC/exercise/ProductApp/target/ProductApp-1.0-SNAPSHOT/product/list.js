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
        let idProduct = $(this).closest("tr").find('td.id').text();
        let nameProduct = $(this).closest("tr").find('td.nameProduct').text();
        let priceProduct = $(this).closest("tr").find('td.priceProduct').text();
        let descriptionProduct = $(this).closest("tr").find('td.descriptionProduct').text();
        let manufacturer = $(this).closest("tr").find('td.manufacturer').text();
        //let imgProduct = $(this).closest("tr").find('td.imgProduct img').attr('src');

        $('.idProduct').val(idProduct);
        $('.nameProduct').val(nameProduct);
        $('.priceProduct').val(priceProduct);
        $('.descriptionProduct').val(descriptionProduct);
        $('.manufacturer').val(manufacturer);
        //$('.imgProduct').val(imgProduct);

    });

    // Check all, uncheck all
    $("#checkAll").change(function (event) {
        var checkbox = $(event.target).closest('table');
        $('td input:checkbox', checkbox).prop('checked', this.checked);
        event.preventDefault();
    });

});