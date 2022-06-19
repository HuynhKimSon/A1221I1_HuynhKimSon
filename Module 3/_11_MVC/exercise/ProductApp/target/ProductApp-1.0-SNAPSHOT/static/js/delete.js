$(document).ready(function() {
    $('#deleteProductModal').on('show.bs.modal', function(e) {
        var deleteid = $(e.relatedTarget).data('delete');
        $('#delBtn').click(function() { //beter if use `onClick` function
            $.ajax({
                cache: false,
                type: 'GET',
                url: "<c:url value=/product?action=delete&id=" + deleteid + ">", //there were also extra commas here
                data: ,
                success: function(data) {}
            });
        });
    });
});