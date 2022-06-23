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
        $('.btn-confirm-delete').attr('href', '/user?action=delete&id=' + IDs + '');
    });

    // Fill input edit Modal
    $('.btn-edit').click(function () {
        let id = $(this).closest("tr").find('td.id').text();
        let name = $(this).closest("tr").find('td.name').text();
        let email = $(this).closest("tr").find('td.email').text();
        let country = $(this).closest("tr").find('td.country').text();

        $('.id').val(id);
        $('.name').val(name);
        $('.email').val(email);
        $('.country').val(country);

    });

    // Check all, uncheck all
    $("#checkAll").change(function (event) {
        var checkbox = $(event.target).closest('table');
        $('td input:checkbox', checkbox).prop('checked', this.checked);
        event.preventDefault();
    });
});