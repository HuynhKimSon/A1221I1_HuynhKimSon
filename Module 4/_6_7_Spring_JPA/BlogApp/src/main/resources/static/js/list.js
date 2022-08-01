$(document).ready(function () {

    // Delete Modal
    $('.btn-delete').click(function () {
        let id = $(this).data('delete-id');
        event.preventDefault();
        $('.btn-confirm-delete').click(function () {
            $.ajax({
                type: "GET",
                url: "/blog/list/delete/" + id,
            });
        });
    });

    // Detail Modal
    $('.btn-detail').click(function () {
        $("#detailModal").modal('show');
        let id = $(this).data('detail-id');
        $.ajax({
            type: "GET",
            url: "/blog/list/detail/" + id,
        });
    });
});