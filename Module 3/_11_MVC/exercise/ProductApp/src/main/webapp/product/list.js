// function confirmDeleteModal(id) {
//     $("#form-confirm-delete").append(
//         '<div class="modal-header">' +
//         '<h4 class="modal-title">Xóa sản phẩm</h4>' +
//         '<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>' +
//         '</div>' +
//         '<div class="modal-body">' +
//         '<p>Bạn có muốn xóa sản phầm?</p>' +
//         '</div>' +
//         '<div class="modal-footer">' +
//         '<input type="button" class="btn btn-default" data-bs-dismiss="modal" value="Hủy">' +
//         '<a type="button" href="/product?action=delete&id=' + id + '" class="btn btn-danger">Có</a>' +
//         '</div>'
//     );
// }

$(document).ready(function () {
    // Delete Modal
    $('.btn-delete').click(function () {
        let id = $(this).data('id');
        $('.btn-confirm-delete').attr('href', '/product?action=delete&id=' + id);
    });

    // Fill input edit Modal
    $('.btn-edit').click(function () {
        let idProduct = $(this).closest("tr").find('td.id').text();
        let nameProduct = $(this).closest("tr").find('td.nameProduct').text();
        let priceProduct = $(this).closest("tr").find('td.priceProduct').text();
        let descriptionProduct = $(this).closest("tr").find('td.descriptionProduct').text();
        let manufacturer = $(this).closest("tr").find('td.manufacturer').text();
        let imgProduct = $(this).closest("tr").find('td.imgProduct img').attr('src');

        $('.idProduct').val(idProduct);
        $('.nameProduct').val(nameProduct);
        $('.priceProduct').val(priceProduct);
        $('.descriptionProduct').val(descriptionProduct);
        $('.manufacturer').val(manufacturer);
        $('.imgProduct').val(imgProduct);

    });
});