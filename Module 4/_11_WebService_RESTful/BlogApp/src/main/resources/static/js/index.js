$(document).ready(function () {

    // Delete Modal
    $('#btn-delete').click(function () {
        let id = $(this).data('delete-id');
        $('.btn-confirm-delete').click(function () {
            $.ajax({
                type: "GET",
                url: "/delete/" + id,
                success: new bootstrap.Toast($('#toast-delete'), {delay: 2200}).show()
            });

        });
    });

    // Detail Modal
    $('#btn-detail').click(function () {
        let id = $(this).data('detail-id');
        $.ajax({
            type: "GET",
            url: "/detail/" + id,
        });

    });

    // Edit Modal
    $('#btn-edit').click(function () {
    });


});