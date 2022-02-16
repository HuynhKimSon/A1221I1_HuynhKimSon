// show prodcut
var listProduct = ["Bánh Socola", "Kẹo"];

function showProductList() {
    let table = "";
    for (let index = 0; index < listProduct.length; index++) {
        table += "<tr>" + "<td style=\"width: 100px\">" + (index + 1) + "</td>" + "<td style=\"width: 400px\">" + listProduct[index] + "</td>" + "<td>" + "<button class=\"btn-edit\" type=\"button\" style=\"background-color: yellow\" onclick='editProduct(" + index + ")'>" + "Sửa" + "</button>" + "</td>" + "<td>" + "<button class=\"btn-delete\" type=\"button\" style=\"background-color: red\" onclick='deleteProduct(" + index + ")'>" + "Xóa" + "</button>" + "</td>" + "</tr>";
    }
    document.getElementById("showProduct").innerHTML = table;
}

// Add product

function addProduct() {
    var item = document.getElementById("nameProduct").value;
    if (currentIndex >= 0) {    // Check valid product
        if (listProduct[currentIndex] != item) {
            listProduct.splice(currentIndex, 1, item);    // Edit product
            currentIndex = -1;
        } else {
            document.getElementById("nameProduct").value = "";
        }
    } else {
        listProduct.push(item);
    }
    showProductList();
}


var currentIndex = -1;

// View product
function editProduct(indexEdit) {
    document.getElementById("nameProduct").value = listProduct[indexEdit];
    currentIndex = indexEdit;
}

// Delete product
function deleteProduct(indexDelete) {
    listProduct.splice(indexDelete, 1);
    showProductList();
}
