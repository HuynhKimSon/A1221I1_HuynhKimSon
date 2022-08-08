$(document).ready(function () {

    // Open Modal Create
    $('#btn-create').click(function () {
        $("#createModal").modal('show');
    });

    // Close Modal
    $('.btn-close-form').click(function () {
        location.replace("/customer")
    });

    // Open Modal Detail
    $('#btn-detail').click(function () {
        let id = $(this).data('detail-id');
        $.ajax({
            type: "GET",
            url: "customer/detail/" + id,
        });
        $("#detailModal").modal('show');
    });
});